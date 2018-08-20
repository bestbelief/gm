package com.mst.front.sentity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@ApiModel(description = "用户邮箱登录")
public class EmailUser {
    @ApiModelProperty(hidden = true)
    private String vCode;

    @ApiModelProperty(value = "用户邮箱地址",required = true,position = 0,example = "2562957962@qq.com")
    @NotEmpty(message = "用户邮箱地址不能为空")
    @Email(message = "邮箱格式不合法")
    private String email;

    @ApiModelProperty(value = "用户密码",required = true,position = 1,example = "2562957962")
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 16, message = "密码长度为6-16位")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "密码只能是数字和字母，区别大小写")
    private String password;
}
