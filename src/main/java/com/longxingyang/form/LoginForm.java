package com.longxingyang.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by a4420 on 18/03/18.
 */
@Data
public class LoginForm {

    @NotEmpty(message = "密码必填")
    private String password;

    @NotEmpty(message = "手机号必填")
    private String userPhone;
}
