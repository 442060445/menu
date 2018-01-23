package com.longxingyang.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用于表单认证
 * Created by a4420 on 18/01/23.
 */
@Data
public class UserForm {

    @NotEmpty(message = "姓名必填")
    private String username;

    @NotEmpty(message = "密码必填")
    private String password;

    @NotEmpty(message = "手机必填")
    private String userPhone;

}