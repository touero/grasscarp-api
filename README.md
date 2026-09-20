# Grasscarp API

A lightweight REST API for querying Chinese university information, majors, and admission scores. Built with Spring Boot and MyBatis-Plus, it exposes simple read-only endpoints backed by a MySQL database.

## Tech Stack

| Component     | Version |
| ------------- | ------- |
| Java          | 1.8     |
| Spring Boot   | 2.6.13  |
| MyBatis-Plus  | 3.5.12  |
| MySQL Driver  | 8.0.33  |
| Build Tool    | Maven   |

## Getting Started

### Prerequisites

- JDK 1.8 or later
- Maven 3.6+
- A MySQL 8.x database

### Database Setup

The database schema and seed data used by this project come from
[`touero/ctenopharyngodon-idella`](https://github.com/touero/ctenopharyngodon-idella):

- SQL script: https://github.com/touero/ctenopharyngodon-idella/blob/master/.withDb/AllSchoolAPI.sql

Import the script into MySQL to create the `AllSchoolAPI` database and its tables:

```bash
mysql -u <username> -p < AllSchoolAPI.sql
```

The application reads from three tables:

- `info` — university information
- `major` — majors offered by each school
- `score` — historical admission scores

### Configuration

Update `src/main/resources/application.properties` with your own database connection details:

```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/AllSchoolAPI?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### Build and Run

```bash
# Build the project
mvn clean package

# Run the application
mvn spring-boot:run
```

Once started, the service is available at `http://localhost:8080`.

## API Reference

Base path: `/api`. All endpoints are `GET` and return JSON.

### 1. Get University Details

```
GET /api/universities/{schoolId}
```

Returns the full information record for the given school.

**Path parameters**

| Name     | Type   | Description   |
| -------- | ------ | ------------- |
| schoolId | string | The school ID |

**Example**

```bash
curl http://localhost:8080/api/universities/10001
```

**Response**

```json
{
  "schoolId": "10001",
  "name": "清华大学",
  "belong": "教育部",
  "provinceId": "11",
  "provinceName": "北京",
  "cityName": "北京市",
  "levelName": "本科",
  "typeName": "综合类",
  "schoolTypeName": "双一流",
  "schoolNatureName": "公办",
  "dualClassName": "985,211",
  "natureName": "普通本科",
  "schoolSite": "https://www.tsinghua.edu.cn",
  "address": "北京市海淀区清华园1号",
  "content": "..."
}
```

### 2. Search Universities

```
GET /api/universities/search?keyword={keyword}
```

Fuzzy-searches universities by name and returns a list of `{ schoolId, name }` pairs.

**Query parameters**

| Name    | Type   | Description              |
| ------- | ------ | ------------------------ |
| keyword | string | Partial university name  |

**Example**

```bash
curl "http://localhost:8080/api/universities/search?keyword=清华"
```

**Response**

```json
[
  { "schoolId": "10001", "name": "清华大学" }
]
```

### 3. Get Majors by School

```
GET /api/majors/{schoolId}
```

Returns the list of majors offered by the given school.

**Path parameters**

| Name     | Type   | Description   |
| -------- | ------ | ------------- |
| schoolId | string | The school ID |

**Example**

```bash
curl http://localhost:8080/api/majors/10001
```

**Response**

```json
[
  {
    "specialName": "计算机科学与技术",
    "typeName": "工学",
    "level3Name": "计算机类",
    "level2Name": "工学",
    "limitYear": "四年"
  }
]
```

### 4. Get Scores by School

```
GET /api/scores/{schoolId}
```

Returns the historical admission scores for the given school.

**Path parameters**

| Name     | Type   | Description   |
| -------- | ------ | ------------- |
| schoolId | string | The school ID |

**Example**

```bash
curl http://localhost:8080/api/scores/10001
```

**Response**

```json
[
  {
    "provinceId": "11",
    "type": "理科",
    "min": "681",
    "year": "2023"
  }
]
```

## Data Model

### University (`info` table)

| Field            | Column             | Description             |
| ---------------- | ------------------ | ----------------------- |
| schoolId         | school_id          | Primary key             |
| name             | name               | University name         |
| belong           | belong             | Affiliation             |
| provinceId       | province_id        | Province ID             |
| provinceName     | province_name      | Province name           |
| site             | site               | Website                 |
| cityName         | city_name          | City name               |
| levelName        | level_name         | Level (e.g. 本科/专科)  |
| typeName         | type_name          | Type                    |
| schoolTypeName   | school_type_name   | School type             |
| schoolNatureName | school_nature_name | School nature           |
| dualClassName    | dual_class_name    | Dual-class designation  |
| natureName       | nature_name        | Nature                  |
| schoolSite       | school_site        | School website          |
| address          | address            | Address                 |
| content          | content            | Description             |

### Major (`major` table)

| Field       | Column       | Description        |
| ----------- | ------------ | ------------------ |
| specialName | special_name | Major name         |
| typeName    | type_name    | Major type         |
| level3Name  | level3_name  | Level-3 category   |
| level2Name  | level2_name  | Level-2 category   |
| limitYear   | limit_year   | Program duration   |

> `school_id` is omitted from JSON responses via `@JsonIgnore`.

### Score (`score` table)

| Field      | Column      | Description       |
| ---------- | ----------- | ----------------- |
| provinceId | province_id | Province ID       |
| type       | type        | Exam type         |
| min        | min         | Minimum score     |
| year       | year        | Admission year    |

> `school_id` is omitted from JSON responses via `@JsonIgnore`.

## License

This project is released under the MIT License, with copyright attributed to
[@touero](https://github.com/touero). See the [LICENSE](LICENSE) file for the
full license text.
