package top.weiensong.grasscarp.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

@TableName("major")
public class Major {

    @JsonIgnore
    @TableField("school_id")
    private String schoolId;

    @TableField("special_name")
    private String specialName;

    @TableField("type_name")
    private String typeName;

    @TableField("level3_name")
    private String level3Name;

    @TableField("level2_name")
    private String level2Name;

    @TableField("limit_year")
    private String limitYear;

    public Major() {
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLevel3Name() {
        return level3Name;
    }

    public void setLevel3Name(String level3Name) {
        this.level3Name = level3Name;
    }

    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name;
    }

    public String getLimitYear() {
        return limitYear;
    }

    public void setLimitYear(String limitYear) {
        this.limitYear = limitYear;
    }
}