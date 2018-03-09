package com.longxingyang.service;

import com.longxingyang.dto.EvaluateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by a4420 on 18/01/23.
 */
public interface EvaluateService {

    //创建评价
    EvaluateDTO create(EvaluateDTO evaluateDTO);

    //查询评价列表
    Page<EvaluateDTO> findList(Pageable pageable);

    //查询个人历史评价
    Page<EvaluateDTO> findListByUserId( String userId, Pageable pageable);

}
