package com.elderlycaresystem.demo.user.entity;

/**
 * @prec:用户实体类
 * @author:CharLinHeng
 * @time:2020年3月28日20:09:56
 */
public class UserEntity {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户账号
     */
    private String userAcct;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPass;
    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 用户地址
     */
    private String userAddress;

    /**
     * 用户身份证
     */
    private String userIdCard;

    /**
     * 用户角色
     */
    private int userRole;

    /**
     * 用户注册时间
     */
    private String userCreateTime;

    /**
     * 用户注册ip地址
     */
    private String userCreateIp;

    /**
     * 用户更新时间
     */
    private String userUpdateTime;

    /**
     * 用户是否已经删除
     */
    private int userIsDelete;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(String userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public String getUserCreateIp() {
        return userCreateIp;
    }

    public void setUserCreateIp(String userCreateIp) {
        this.userCreateIp = userCreateIp;
    }

    public String getUserUpdateTime() {
        return userUpdateTime;
    }

    public void setUserUpdateTime(String userUpdateTime) {
        this.userUpdateTime = userUpdateTime;
    }

    public int getUserIsDelete() {
        return userIsDelete;
    }

    public void setUserIsDelete(int userIsDelete) {
        this.userIsDelete = userIsDelete;
    }
}
