package com.mst.front.web;

import com.mst.db.domain.UserInfo;
import com.mst.front.sentity.EmailUser;
import com.mst.front.tempentity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@EnableAutoConfiguration
@Api(tags = {"/login"},description = "用户登录模块")
@RequestMapping(value = "/login")
public class LoginController {

    @ApiOperation(value = "/emailLogin",notes = "用户通过email进行登录")
    @RequestMapping(value = "/emailLogin",method = RequestMethod.POST)
    private Result emailLogin(@RequestBody @Validated EmailUser emailUser, BindingResult result){


        return new Result();
    }

}
