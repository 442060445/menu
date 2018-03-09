package com.longxingyang.controller;


import com.longxingyang.dto.EvaluateDTO;
import com.longxingyang.service.EvaluateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by a4420 on 18/03/08.
 */
@Controller
@RequestMapping("/evaluate")
@Slf4j
public class SellerEvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    /**
     * 评论列表
     * @param page 第几页, 默认从1页开始
     * @param size 一页有多少条数据，默认10条/页
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<EvaluateDTO> evaluateDTOPage = evaluateService.findList(request);
        map.put("EvaluateDTOPage", evaluateDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("ratings/list", map);
    }


}
