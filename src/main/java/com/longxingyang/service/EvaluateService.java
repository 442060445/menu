package com.longxingyang.service;

import com.longxingyang.dataobject.Evaluate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by a4420 on 18/01/23.
 */
public interface EvaluateService {
    //创建评价
    Evaluate create(Evaluate orderDTO);

    //查询评价列表
    Page<Evaluate> findList(Pageable pageable);


}
