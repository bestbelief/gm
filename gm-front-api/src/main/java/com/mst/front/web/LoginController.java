package com.mst.front.web;

import com.alibaba.druid.sql.visitor.functions.If;
import com.mst.db.domain.UserAuth;
import com.mst.db.domain.UserInfo;
import com.mst.db.service.UserService;
import com.mst.front.constant.StatuCodeEnum;
import com.mst.front.constant.UserIdentityTypeEnum;
import com.mst.front.sentity.EmailUser;
import com.mst.front.tempentity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController()
@EnableAutoConfiguration
@Api(tags = {"/login"},description = "用户登录模块")
@RequestMapping(value = "/login")
public class LoginController {
    @Resource(name = "UserServiceImpl")
    private UserService userService;
    @ApiOperation(value = "/emailLogin",notes = "用户通过email进行登录")
    @RequestMapping(value = "/emailLogin",method = RequestMethod.POST)
    private Result emailLogin(@RequestBody @Validated EmailUser emailUser, BindingResult result){
        List<String>listError=new ArrayList<String>();
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                listError.add(error.getDefaultMessage());
            }
            return new Result(StatuCodeEnum.RETCODE_400,null,listError);
        }
        UserAuth userAuth=new UserAuth();
        userAuth.setIdentifier(emailUser.getEmail());
        UserAuth reUserAuth=userService.getUserAuthByIdentifier(userAuth);
        if(reUserAuth ==null){
            return new Result(StatuCodeEnum.RETCODE_500,"该用户不存在",null);
        }
        UserInfo userInfo=new UserInfo();
        userInfo.setId(reUserAuth.getUserId());
        UserInfo reUserInfo=userService.getUserInfoByID(userInfo);
        if(!reUserInfo.getPassword().equals(emailUser.getPassword())){
            return new Result(StatuCodeEnum.RETCODE_500,"密码错误",null);
        }
        return new Result(StatuCodeEnum.RETCODE_200,null,reUserAuth);
    }

}
