package com.elderlycaresystem.demo.user.service;
import com.elderlycaresystem.demo.user.dao.UserDao;
import com.elderlycaresystem.demo.user.entity.UserEntity;
import com.elderlycaresystem.demo.user.entity.UserListParamEntiry;
import com.elderlycaresystem.demo.util.RandomCode;
import com.elderlycaresystem.demo.util.ResponceData;
import com.elderlycaresystem.demo.util.ResponceDataState;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Deprecated 用于用户表相关事务服务
 * @author CharLinHeng
 * @date  2020年3月28日22:02:45
 */
@Service
public class UserService {
    private ResponceData responceData;
    @Resource
    private UserDao userDao;
    /**
     * 删除用户服务控制
     * @param httpServletRequest
     * @return
     */
    public ResponceData deleteUser(HttpServletRequest httpServletRequest){
        //判断是否为空
        if(null == httpServletRequest.getParameter("userCodeList") || httpServletRequest.getParameter("userCodeList")==""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"参数不存在或者不能为空!",null);
        }
        //将字符串转成List
        List<String>deleteUserList = Arrays.asList(httpServletRequest.getParameter("userCodeList").split(","));
        //调用删除方法，进行删除
        int result = userDao.deleteUser(deleteUserList);
        return new ResponceData(ResponceDataState.values()[0].getCode(),"删除成功!",result);
    }

    /**
     * 修改用户信息
     * @param userEntity
     * @return
     */
    public ResponceData updateUserData(UserEntity userEntity){
        if(null == userEntity.getUserCode() || userEntity.getUserCode() == ""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"编号参数不存在或者不能为空!",null);
        }
        //先判断用户账号是否存在
        int userAcctNum = userDao.countAcct(userEntity);
        if(userAcctNum>0){//说明用户账号已经存在
            responceData = new ResponceData(ResponceDataState.values()[9].getCode(),"用户账号已经存在",null);
            return responceData;
        }
        //没问题后，新增 当然也可以在mybatis中使用if来判断，根据个人需求
        if(null == userEntity.getUserAcct()){
            userEntity.setUserAcct("");
        }
        if(null == userEntity.getUserEmail()){
            userEntity.setUserEmail("");
        }
        if(null == userEntity.getUserPhone()){
            userEntity.setUserPhone("");
        }
        //更新
        int result = userDao.updateUserData(userEntity);
        return new ResponceData(ResponceDataState.values()[0].getCode(),"更新成功!",result);
    }
    /**
     * 查询值顶用户信息
     * @param httpServletRequest
     * @return
     */
    public ResponceData queryDetails(HttpServletRequest httpServletRequest){
        if(null == httpServletRequest.getParameter("userCode") || httpServletRequest.getParameter("userCode")==""){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"参数不存在或者不能为空!",null);
        }
        UserEntity result = userDao.queryDetail(httpServletRequest.getParameter("userCode"));
        return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",result);
    }
    /**
     * 新增用户服务控制
     * @param userEntity
     * @return
     */
    public ResponceData addUser(UserEntity userEntity){
        //先判断用户账号是否存在
        int userAcctNum = userDao.countAcct(userEntity);
        if(userAcctNum>0){//说明用户账号已经存在
            responceData = new ResponceData(ResponceDataState.values()[9].getCode(),"用户账号已经存在",null);
            return responceData;
        }
        //给用户创建用户编号
        userEntity.setUserCode(RandomCode.radmonkey());
        //没问题后，新增
        if(null == userEntity.getUserAcct()){
            userEntity.setUserAcct("");
        }
        if(null == userEntity.getUserEmail()){
            userEntity.setUserEmail("");
        }
        if(null == userEntity.getUserPhone()){
            userEntity.setUserPhone("");
        }
        //
        int result = userDao.addUser(userEntity);
        if(result>0){ //说明新增成功
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"新增用户成功!",null);
        }
        else{ // 失败
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"新增用户失败!",null);
        }
        return responceData;
    }

    /**
     * 列表分页模糊查询
     * @param userListParamEntiry
     * @return
     */
    public ResponceData queryUserList(UserListParamEntiry userListParamEntiry){
        //分页工具进行 分页，参数为  页显示数量，页显示号
        PageHelper.startPage(userListParamEntiry.getPageNum(),userListParamEntiry.getPageSize());
        //调用方法
        List<UserEntity>userEntityList = userDao.queryUserList(userListParamEntiry);
        //包装查询后的信息，增加一些分页信息
        PageInfo<UserEntity>userEntityPageInfo = new PageInfo<>(userEntityList);
        return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",userEntityPageInfo);
    }
    /**
     * 验证
     * @param userName
     * @param PassWord
     * @return
     */
//    public ResponceData queryAcct(String userName,String PassWord){
//
//
//        if(null == userName || null ==  PassWord){
//            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"用户名或者密码不能为空!",null);
//            return responceData;
//        }
//        //判断账号是否存在
//        int result = userDao.judgeHasExist(userName);
//        if(result < 0 ){
//            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"用户名或者手机号不存在!",null);
//        }
//        //检测
////        String code = userDao.judgeLogin(userName,PassWord);
//
//        if(null != code){
//            //查询所有信息，给你
//            UserEntity userEntity = userDao.queryDetails(code);
//
//
//            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"登入成功!",userEntity);
//        }
//        else{
//            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"密码错误!",null);
//        }
//        return responceData;
//    }

//    /**
//     * 查询详情
//     * @param userEntity
//     * @return
//     */
//    public ResponceData queryDetail(UserEntity userEntity){
//
//        if(null == userEntity.getUserCode()){
//            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"参数不能为空!",null);
//            return responceData;
//        }
//        //查询
//
//        System.out.println(userEntity.getUserCode());
//        //
//        UserEntity userEntity1 = userDao.queryDetails(userEntity.getUserCode());
////        System.out.println("长度:"+userEntity1.size());
//
//        if(null == userEntity1){
//            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
//        }
//        else{
//            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",userEntity1);
//        }
//        return responceData;
//    }

    /**
     * 方案
     * @return
     */
    public ResponceData give(){

        //方案
        List<String>fangan = new ArrayList<>();
        Map<String,List<String>> fangan_ = new HashMap<>();


        fangan.add("您好，根据你所给到信息。我们为您推荐的是居家养老，\n" +
                "老年人在日常生活中可以不受时间和地理环境的束缚，\n" +
                "在自己家中过上高质量高享受的生活。祝您生活幸福愉快。\n");
        fangan.add( "您好，根据您所给到的信息。我们为您推荐的是养老院养老，\n" +
                "养老院养老能让老人享受到更优质的服务，养老院作为专业的养老机构，\n" +
                "服务得到位。祝您甚或愉快。");
        fangan.add("您好，根据你所给到的信息，我们为您推荐的是医院疗养，\n" +
                "老人身体不适，即时地处理病情能防患于未然，祝您生活愉快");
        fangan_.put("name",fangan);
        responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"模拟成功!",fangan_);
        return responceData;
    }

}
