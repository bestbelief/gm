package com.mst.front.web;

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
@Api(tags = {"/register"},description = "用户注册")
@RequestMapping(value = "/register")
public class RegisterController {
    @Resource(name = "UserServiceImpl")
    private UserService userService;
    @ApiOperation(value = "/emailRegister",notes = "用户通过email进行注册")
    @RequestMapping(value = "/emailRegister",method = RequestMethod.POST)
    private Result emailLogin(@RequestBody @Validated EmailUser emailUser, BindingResult result){
        List<String> listError=new ArrayList<String>();
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                listError.add(error.getDefaultMessage());
            }
            return new Result(StatuCodeEnum.RETCODE_400,null,listError);
        }
        UserAuth userAuth=new UserAuth();
        userAuth.setIdentityType(UserIdentityTypeEnum.EMAIL.getValue());
        userAuth.setIdentifier(emailUser.getEmail());
        UserAuth reUserAuth=userService.getUserAuthByIdentifier(userAuth);
        if(reUserAuth !=null){
            return new Result(StatuCodeEnum.RETCODE_500,"用户重复注册",null);
        }
        UserInfo userInfo=new UserInfo();
        userInfo.setCreateTime(LocalDateTime.now());
        userInfo.setPassword(emailUser.getPassword());
        try {
            userService.addUserByRegistEmail(userInfo,userAuth);
        } catch (Exception e) {
            return new Result(StatuCodeEnum.RETCODE_500,null,null);
        }
        return new Result(StatuCodeEnum.RETCODE_200,null,userAuth);
    }

}
