package com.longxingyang.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Integer rating;

    //评价内容
    private String content;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

}
