package com.drool.engine.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName("re_param_info")
public class ParamInfo {

    @TableId("id")
    private String id ;
    private String paramSign ;
    private Date createTime ;
    private Date updateTime ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParamSign() {
        return paramSign;
    }

    public void setParamSign(String paramSign) {
        this.paramSign = paramSign;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
