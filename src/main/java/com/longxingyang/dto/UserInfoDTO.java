package com.longxingyang.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.longxingyang.enums.AccountStatusEnum;
import com.longxingyang.utils.EnumUtil;
import com.longxingyang.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.util.Date;

/**
 * Created by a4420 on 18/01/23.
 */
@Data
public class UserInfoDTO {

    private String userId;

    //用户名
    private String username;

    //密码
    private String password;

    //手机
    private String userPhone;

    //用户openid
    private String openid;

    //帐号状态
    private Integer accountStatus;

    //帐号类型
    private String accountType;

    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    //修改时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    @JsonIgnore
    public AccountStatusEnum getAccountStatusEnum() {
        return EnumUtil.getByCode(accountStatus, AccountStatusEnum.class);
    }

}
