package com.example.demo.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * @author xin
 * @create 2020-11-23 02:34:48
 */
//@Api(注释)
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户名")
     public String username;
    @ApiModelProperty("密码")
     public String password;
}
