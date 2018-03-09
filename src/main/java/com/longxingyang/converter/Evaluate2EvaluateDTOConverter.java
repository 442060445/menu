package com.longxingyang.converter;

import com.longxingyang.dataobject.Evaluate;
import com.longxingyang.dto.EvaluateDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by a4420 on 18/03/08.
 */
public class Evaluate2EvaluateDTOConverter {
    public static EvaluateDTO convert(Evaluate evaluate){
        EvaluateDTO evaluateDTO = new EvaluateDTO();
        BeanUtils.copyProperties(evaluate, evaluateDTO);
        return evaluateDTO;
    }

    public static List<EvaluateDTO> convert (List<Evaluate> evaluateList){
        return evaluateList.stream().map(e ->
                convert((e))
        ).collect(Collectors.toList());
    }
}
