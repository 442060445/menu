package com.longxingyang.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用于管理员帐号的表单验证
 * Created by a4420 on 18/01/24.
 */
@Data
public class AdminForm {

    @NotEmpty(message = "ID必填")
    private String userId;

    @NotEmpty(message = "姓名必填")
    private String username;

    @NotEmpty(message = "密码必填")
    private String password;

    @NotEmpty(message = "手机必填")
    private String userPhone;

    //用户openid
    private String openid;

    //帐号类型
    private String accountType;
}
