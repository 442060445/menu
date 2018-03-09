package com.longxingyang.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**用于评价模块的表单验证
 * Created by a4420 on 18/02/09.
 */
@Data
public class EvaluateForm {

    @NotEmpty(message = "ID必填")
    private String userId;

    //用户名
    @NotEmpty(message = "姓名必填")
    private String username;

    //评分
    @NotNull(message = "评分必填")
    private Integer rating;

    //评价内容
    @NotEmpty(message = "内容必填")
    private String content;
}
