package com.longxingyang.service.Impl;

import com.longxingyang.converter.Evaluate2EvaluateDTOConverter;
import com.longxingyang.dataobject.Evaluate;
import com.longxingyang.dto.EvaluateDTO;
import com.longxingyang.repository.EvaluateRepository;
import com.longxingyang.service.EvaluateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by a4420 on 18/02/08.
 */
@Service
public class EvaluateServiceImpl implements EvaluateService{

    @Autowired
    EvaluateRepository evaluateRepository;

    @Override
    public EvaluateDTO create(EvaluateDTO evaluateDTO) {
        Evaluate evaluate = new Evaluate();
        BeanUtils.copyProperties(evaluateDTO, evaluate);
        evaluateRepository.save(evaluate);
        return evaluateDTO;
    }

    @Override
    public Page<EvaluateDTO> findList(Pageable pageable) {
        Page<Evaluate> evaluatePage = evaluateRepository.findAll(pageable);
        List<EvaluateDTO> evaluateDTOList = Evaluate2EvaluateDTOConverter.convert(evaluatePage.getContent());
        return new PageImpl<EvaluateDTO>(evaluateDTOList, pageable, evaluatePage.getTotalElements());
    }

    @Override
    public Page<EvaluateDTO> findListByUserId(String userId, Pageable pageable) {
        Page<Evaluate> evaluatePage = evaluateRepository.findByUserId(userId, pageable);
        List<EvaluateDTO> evaluateDTOList = Evaluate2EvaluateDTOConverter.convert(evaluatePage.getContent());
        return new PageImpl<EvaluateDTO>(evaluateDTOList, pageable, evaluatePage.getTotalElements());
    }
}
