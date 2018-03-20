package com.longxingyang.controller;

import com.longxingyang.VO.ResultVO;
import com.longxingyang.dto.UserInfoDTO;
import com.longxingyang.enums.ResultEnum;
import com.longxingyang.exception.SellException;
import com.longxingyang.form.AdminForm;
import com.longxingyang.service.UserInfoService;
import com.longxingyang.utils.KeyUtil;
import com.longxingyang.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by a4420 on 18/01/24.
 */
@CrossOrigin
@Controller
@Slf4j
public class RegisterController {
    @Autowired
    private UserInfoService userInfoService;

    private final static String OPENID = "00000000000";

    @PostMapping("/registerPoset")
    @ResponseBody
    public ResultVO<Map<String, String>> save(@Valid AdminForm form,
                                              BindingResult bindingResult
                                              ) {
        if (bindingResult.hasErrors()) {
            return ResultVOUtils.fail(-1, bindingResult.getFieldError().getDefaultMessage());
        }

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        try {
            if (!StringUtils.isEmpty(form.getUserId())) {
                userInfoDTO = userInfoService.findOne(form.getUserId());
            } else {
                form.setUserId(KeyUtil.genUniqueKey());
                userInfoDTO.setUserId(form.getUserId());
                userInfoDTO.setAccountType("0");
                userInfoDTO.setAccountStatus(0);
                userInfoDTO.setOpenid(OPENID);
            }
            userInfoDTO.setPassword(form.getPassword());
            userInfoDTO.setUserPhone(form.getUserPhone());
            userInfoDTO.setUsername(form.getUsername());
            userInfoService.save(userInfoDTO);

        } catch (SellException e) {
            return ResultVOUtils.fail(-1, e.getMessage());
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userInfoDTO", userInfoDTO);
        return ResultVOUtils.success(map);
    }

}
