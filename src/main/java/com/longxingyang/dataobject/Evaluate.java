package com.longxingyang.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by a4420 on 18/01/23.
 */
@DynamicUpdate
@Entity
@Data
public class Evaluate {

    @Id
    private String evaluateId;

    private String userId;

    //用户名
    private String username;

    //评分
    private String rating;

    //评价内容
    private String content;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

}
