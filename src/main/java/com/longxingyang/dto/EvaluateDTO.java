package com.longxingyang.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.longxingyang.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.util.Date;

/**
 * Created by a4420 on 18/03/08.
 */
@Data
public class EvaluateDTO {

    private String evaluateId;

    private String userId;

    //用户名
    private String username;

    //评分
    private Integer rating;

    //评价内容
    private String content;

    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    //修改时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

}
