package com.elderlycaresystem.demo.user.controller;
import com.elderlycaresystem.demo.user.entity.UserEntity;
import com.elderlycaresystem.demo.user.entity.UserListParamEntiry;
import com.elderlycaresystem.demo.user.service.UserService;
import com.elderlycaresystem.demo.util.PhoneCode;
import com.elderlycaresystem.demo.util.RandomCode;
import com.elderlycaresystem.demo.util.ResponceData;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
@CrossOrigin
/**
 * 用户模块控制类
 * CharLinHeng
 * 2020年3月28日23:53:19
 */
public class UserController {
    private ResponceData responceData;
    @Resource
    private UserService userService;
    @ResponseBody
    /**
     * 删除用户controller
     */
    @PostMapping("deleteUser")
    public ResponceData deleteUser(HttpServletRequest httpServletRequest){
        try{
            return userService.deleteUser(httpServletRequest);
        }catch (Exception e){
            throw e;
        }
    }
//    /**
//     * 登入验证
//     */
//    @PostMapping("query")
//    public ResponceData send(HttpServletRequest httpServletRequest){
//
//      try{
//          String userName = httpServletRequest.getParameter("userName");
//          String passWord = httpServletRequest.getParameter("passWord");
////          System.out.println(userName+","+passWord);
//          responceData = userService.queryAcct(userName,passWord);
//      }catch (Exception e){
//          throw e;
//      }
//        return responceData;
//    }
    /**
     * 新增用户调用地址
     * 2020年3月28日23:53:46
     */
    @PostMapping("addUser")
    public ResponceData addUser(UserEntity userEntity){

        try{
            responceData = userService.addUser(userEntity);
            return responceData;
        }catch (Exception e){
            throw  e;
        }
    }
    /**
     * 查询用户详情
     * @param httpServletRequest
     * @return
     */
    @PostMapping("userDetail")
    public ResponceData userDetail(HttpServletRequest httpServletRequest){
        try{
            responceData = userService.queryDetails(httpServletRequest);
            return responceData;
        }catch (Exception e){
            throw  e;
        }
    }

    /**
     * 更新用户
     * @param userEntity
     * @return
     */
    @PostMapping("updateUserData")
    public ResponceData updateUserData(UserEntity userEntity){
        try{
            responceData = userService.updateUserData(userEntity);
            return responceData;
        }catch (Exception e){
            throw  e;
        }
    }

    /**
     * 列表分页模糊查询用户
     * @param userListParamEntiry
     * @return
     */
    @PostMapping("getUserListData")
    public ResponceData getUserListData(UserListParamEntiry userListParamEntiry){
        try{
            responceData = userService.queryUserList(userListParamEntiry);
            return responceData;
        }catch (Exception e){
            throw  e;
        }
    }
}