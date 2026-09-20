package top.weiensong.grasscarp.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("info")
public class University {

    @TableId("school_id")
    private String schoolId;

    private String name;

    private String belong;

    @TableField("province_id")
    private String provinceId;

    @TableField("province_name")
    private String provinceName;

    private String site;

    @TableField("city_name")
    private String cityName;

    @TableField("level_name")
    private String levelName;

    @TableField("type_name")
    private String typeName;

    @TableField("school_type_name")
    private String schoolTypeName;

    @TableField("school_nature_name")
    private String schoolNatureName;

    @TableField("dual_class_name")
    private String dualClassName;

    @TableField("nature_name")
    private String natureName;

    @TableField("school_site")
    private String schoolSite;

    private String address;

    private String content;

    public University() {
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSchoolTypeName() {
        return schoolTypeName;
    }

    public void setSchoolTypeName(String schoolTypeName) {
        this.schoolTypeName = schoolTypeName;
    }

    public String getSchoolNatureName() {
        return schoolNatureName;
    }

    public void setSchoolNatureName(String schoolNatureName) {
        this.schoolNatureName = schoolNatureName;
    }

    public String getDualClassName() {
        return dualClassName;
    }

    public void setDualClassName(String dualClassName) {
        this.dualClassName = dualClassName;
    }

    public String getNatureName() {
        return natureName;
    }

    public void setNatureName(String natureName) {
        this.natureName = natureName;
    }

    public String getSchoolSite() {
        return schoolSite;
    }

    public void setSchoolSite(String schoolSite) {
        this.schoolSite = schoolSite;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}