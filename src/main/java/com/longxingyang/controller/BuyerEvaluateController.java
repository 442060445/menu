package com.longxingyang.controller;

import com.longxingyang.VO.ResultVO;
import com.longxingyang.converter.EvaluateForm2EvaluateDTOConverter;
import com.longxingyang.dto.EvaluateDTO;
import com.longxingyang.enums.ResultEnum;
import com.longxingyang.exception.SellException;
import com.longxingyang.form.EvaluateForm;
import com.longxingyang.repository.EvaluateRepository;
import com.longxingyang.service.EvaluateService;
import com.longxingyang.utils.KeyUtil;
import com.longxingyang.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a4420 on 18/02/09.
 */
@CrossOrigin
@RestController
@RequestMapping("/buyer/evaluate")
@Slf4j
public class BuyerEvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private EvaluateRepository evaluateRepository;

    //创建评价
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid EvaluateForm evaluateForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //log.error("【新增评价】参数不正确, orderForm={}", evaluateForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        EvaluateDTO evaluateDTO = EvaluateForm2EvaluateDTOConverter.convert(evaluateForm);
        evaluateDTO.setEvaluateId(KeyUtil.genUniqueKey());
        EvaluateDTO createResult = evaluateService.create(evaluateDTO);

        Map<String, String> map = new HashMap<>();
        map.put("UserId", createResult.getUserId());

        return ResultVOUtils.success(map);
    }

    //查询个人评价
    @GetMapping("/list")
    public ResultVO<List<EvaluateDTO>> list(@RequestParam("userId") String userId,
                                            @RequestParam(value = "page", defaultValue = "0") Integer page,
                                            @RequestParam(value = "size", defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(userId)) {
            //log.error("【查询评价列表】userId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = new PageRequest(page, size);
        Page<EvaluateDTO> evaluateDTOPage= evaluateService.findListByUserId(userId, request);
        return ResultVOUtils.success(evaluateDTOPage.getContent());
    }


}
