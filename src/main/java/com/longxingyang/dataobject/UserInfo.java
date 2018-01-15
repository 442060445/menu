package com.longxingyang.dataobject;

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

    private String username;

    private String password;

    private String openid;

    private Date createTime;

    private Date updateTime;

}
