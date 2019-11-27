package com.fsocity.security.springboot.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
/**
 * 默认情况下两个都生效
 * AccessType.FIELD: 只对字段的注解生效
 * AccessType.PROPERTY: 只对getter和setter方法属性的注解生效
 */
// @Access(value = AccessType.PROPERTY)
@DynamicUpdate
@Table(name = "spring_boot_user_info")
public class UserInfo {
    
    @Id
    @GeneratedValue
    private Integer userId;
    
    @Column(length = 20)
    private String userName;
    
    private Integer userAge;
    
    @Column(length = 20)
    private String userPhone;
    
    @Column(length = 50)
    private String userPassword;
    
    @Column(nullable = false, columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;
    
    @Column(nullable = false, columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Integer getUserAge() {
        return userAge;
    }
    
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
    
    public String getUserPhone() {
        return userPhone;
    }
    
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    
    public String getUserPassword() {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
