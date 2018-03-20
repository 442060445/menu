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
import com.sun.org.apache.xpath.internal.operations.Mod;
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

    /**
     * 卖家管理系统登录验证
     *
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/loginPost")
    @ResponseBody
    public ModelAndView loginPost(@Valid LoginForm form,
                              BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            log.error("【登录失败】参数不正确, LoginForm={}", form);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        Map<String, Object> map = new HashMap<>();
        UserInfoDTO userInfoDTO = userInfoService.findOneByPhone(form.getUserPhone());
        if (form.getPassword().hashCode() != userInfoDTO.getPassword().hashCode()) {
            map.put("userInfoDTO", form);
            map.put("msg", ResultEnum.LOGIN_FAIL.getMsg());
            map.put("url", "/sell/login.html");
            return new ModelAndView("common/error", map);
        }

        if (userInfoDTO.getAccountStatus().equals(0)) {
            if(userInfoDTO.getAccountType().equals("1")) {
                // 设置session
                session.setAttribute(WebSecurityConfig.SESSION_KEY, userInfoDTO.getUsername());
                map.put("msg", ResultEnum.LOGIN_SUCCESS.getMsg());
                map.put("url", "/sell/seller/order/list");
                return new ModelAndView("common/success", map);
            }else {
                map.put("userInfoDTO", form);
                map.put("msg", ResultEnum.NO_RIGHT.getMsg());
                map.put("url", "/sell/login.html");
                return new ModelAndView("common/error", map);
            }
        }else {
            map.put("msg", ResultEnum.ACCOUNT_STATUS_ERROR.getMsg());
            map.put("url", "/sell/login.html");
            return new ModelAndView("common/error", map);
        }

    }

    /**
     * 顾客登录验证
     *
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/loginPost2")
    @ResponseBody
    public ResultVO<Map<String, String>> loginPost2(@Valid LoginForm form,
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
        map.put("username", userInfoDTO.getUsername());
        map.put("userId", userInfoDTO.getUserId());
        map.put("userPhone",userInfoDTO.getUserPhone());
        return ResultVOUtils.success(map);
    }

    /**
     * 卖家管理系统登出处理
     *
     * @return
     */
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);

        Map<String, Object> map = new HashMap<>();
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMsg());
        map.put("url", "/sell/login.html");
        return new ModelAndView("common/success",map);
    }

    /**
     * 顾客登出处理
     *
     * @return
     */
    @GetMapping("/logout2")
    public String logout2(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/index";//"redirect:http://192.168.56.102:8899/"
    }
}
