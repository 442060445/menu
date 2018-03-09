package com.longxingyang.converter;

import com.google.gson.Gson;
import com.longxingyang.dto.EvaluateDTO;
import com.longxingyang.form.EvaluateForm;

/**
 * Created by a4420 on 18/03/09.
 */
public class EvaluateForm2EvaluateDTOConverter {
    public static EvaluateDTO convert(EvaluateForm evaluateForm){
        Gson gson = new Gson();
        EvaluateDTO evaluateDTO = new EvaluateDTO();

        evaluateDTO.setUsername(evaluateForm.getUsername());
        evaluateDTO.setContent(evaluateForm.getContent());;
        evaluateDTO.setUserId(evaluateForm.getUserId());
        evaluateDTO.setRating(evaluateForm.getRating());
        return evaluateDTO;
    }
}
