package com.elderlycaresystem.demo.user.entity;
/**
 * @Deprecated 分页列表显示参数-实体类
 * @author charlinheng
 * @date 2020年5月24日
 */
public class UserListParamEntiry {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     *用户手机号
     */
    private String userPhone;
    /**
     *页显示数量
     */
    private int pageSize;
    /**
     *页号
     */
    private int pageNum;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
