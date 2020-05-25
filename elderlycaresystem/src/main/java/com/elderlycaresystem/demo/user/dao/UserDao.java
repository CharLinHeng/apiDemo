package com.elderlycaresystem.demo.user.dao;
import com.elderlycaresystem.demo.user.entity.UserEntity;
import com.elderlycaresystem.demo.user.entity.UserListParamEntiry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description UserDao层服务
 * @author CharLinHengu
 * @date 2020年3月28日21:09:42
 */
@Mapper
public interface UserDao {
    /**
     * 判断用户账号是存在
     * 当返回的值大于0时表示此用户账号已经存在。
     * @param user
     * @return int
     */
    int countAcct(UserEntity user);

    /**
     *查看是否存在
     */
    int judgeHasExist(@Param("userAcct")String acct);
    /**
     * 新增用户
     * @param userEntity
     * @return
     * 2020年3月28日23:24:33
     */
    int addUser(UserEntity userEntity);

    /**
     * 删除用户
     * @param deleteUserCodeList
     * @return
     */
    int deleteUser(@Param("deleteCodeList")List<String>deleteUserCodeList);
    /**
     * 用户详情
     */
    UserEntity queryDetail(@Param("userCode")String userCode);

    /**
     * 更新用户信息
     * @param userEntity
     * @return
     */
    int updateUserData(UserEntity userEntity);

    /**
     * 分页列表查询用户信息
     * @param userListParamEntiry
     * @return
     */
    List<UserEntity> queryUserList(UserListParamEntiry userListParamEntiry);
}
