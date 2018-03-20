package com.longxingyang.controller;

import com.longxingyang.VO.ResultVO;
import com.longxingyang.configuration.WebSecurityConfig;
import com.longxingyang.dataobject.UserInfo;
import com.longxingyang.dto.UserInfoDTO;
import com.longxingyang.enums.ResultEnum;
import com.longxingyang.exception.SellException;
import com.longxingyang.form.LoginForm;
import com.longxingyang.form.UserForm;
import com.longxingyang.service.UserInfoService;
import com.longxingyang.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by a4420 on 18/03/18.
 */
@CrossOrigin
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

/*    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
        model.addAttribute("name", account);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "/sell/login";
    }*/

    @PostMapping("/loginPost")
    @ResponseBody
    public ResultVO<Map<String, String>> loginPost(@Valid LoginForm form,
                              BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            log.error("【登录失败】参数不正确, LoginForm={}", form);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        Map<String, Object> map = new HashMap<>();
        UserInfoDTO userInfoDTO = userInfoService.findOneByPhone(form.getUserPhone());
        if (form.getPassword().hashCode() != userInfoDTO.getPassword().hashCode()) {
            return ResultVOUtils.fail(-1,"密码错误");
        }

        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, userInfoDTO.getUsername());

        map.put("username", userInfoDTO.getUsername());
        map.put("userId", userInfoDTO.getUserId());
        map.put("userPhone",userInfoDTO.getUserPhone());
        return ResultVOUtils.success(map);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/";//"redirect:http://192.168.56.102:8899/"
    }
}
