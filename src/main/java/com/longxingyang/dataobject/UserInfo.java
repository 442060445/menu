package com.longxingyang.dataobject;

import com.longxingyang.enums.AccountStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by a4420 on 18/01/15.
 */
@Data
@Entity
@DynamicUpdate
public class UserInfo {

    @Id
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
    private Integer accountStatus = AccountStatusEnum.NORMAL.getCode();

    //帐号类型
    private String accountType;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

}
