package com.longxingyang.controller;

import com.longxingyang.converter.UserInfo2UserInfoDTOConverter;
import com.longxingyang.dataobject.ProductInfo;
import com.longxingyang.dataobject.UserInfo;
import com.longxingyang.dto.UserInfoDTO;
import com.longxingyang.enums.AccountStatusEnum;
import com.longxingyang.enums.ResultEnum;
import com.longxingyang.exception.SellException;
import com.longxingyang.form.AdminForm;
import com.longxingyang.form.UserForm;
import com.longxingyang.repository.UserInfoRepository;
import com.longxingyang.service.UserInfoService;
import com.longxingyang.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by a4420 on 18/01/23.
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfoRepository repository;

    private final static String OPENID = "00000000000";

    /**
     * 用户列表
     * @param page 第几页, 默认从1页开始
     * @param size 一页有多少条数据，默认10条/页
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<UserInfoDTO> userInfoDTOPage = userInfoService.findList(request);
        map.put("userInfoDTOPage", userInfoDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("user/list", map);
    }

    /**
     * 禁用帐号
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/disable")
    public ModelAndView disable(@RequestParam("userId") String userId,
                                Map<String, Object> map){
        try {
            UserInfoDTO userInfoDTO = UserInfo2UserInfoDTOConverter.convert(repository.findOne(userId));
            userInfoService.disable(userInfoDTO);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/user/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ACCOUNT_UPDATE_SUCCESS.getMsg());
        map.put("url", "/sell/user/list");
        return new ModelAndView("common/success", map);
    }

    /**
     *  激活帐号
     *  @param userId 用户ID
     *  @return
     */
    @GetMapping("/enable")
    public ModelAndView enable(@RequestParam("userId") String userId,
                                Map<String, Object> map){
        try {
            UserInfoDTO userInfoDTO = UserInfo2UserInfoDTOConverter.convert(repository.findOne(userId));
            userInfoService.enable(userInfoDTO);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/user/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ACCOUNT_UPDATE_SUCCESS.getMsg());
        map.put("url", "/sell/user/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 新增/修改帐号详情
     *  @param userId 用户ID
     *  @map
     *  @return
     *
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "userId", required = false) String userId,
                             Map<String, Object> map){
        if(!StringUtils.isEmpty(userId)){
            UserInfoDTO userInfoDTO = userInfoService.findOne(userId);
            map.put("userInfoDTO", userInfoDTO);
        }else{
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            map.put("userInfoDTO", userInfoDTO);
        }

        return new ModelAndView("user/index", map);
    }

    /**
     * 保存/更新帐号详情
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid AdminForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map){
        if(bindingResult.hasErrors()){
            map.put("userInfoDTO", form);
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/user/index");
            return new ModelAndView("common/error", map);
        }

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        try {
            if (!StringUtils.isEmpty(form.getUserId())){
                userInfoDTO = userInfoService.findOne(form.getUserId());
            }else {
                form.setUserId(KeyUtil.genUniqueKey());
                userInfoDTO.setUserId(form.getUserId());
                userInfoDTO.setAccountType("1");
                userInfoDTO.setAccountStatus(0);
                userInfoDTO.setOpenid(OPENID);
            }
            userInfoDTO.setPassword(form.getPassword());
            userInfoDTO.setUserPhone(form.getUserPhone());
            userInfoDTO.setUsername(form.getUsername());
            userInfoService.save(userInfoDTO);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/user/index");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ACCOUNT_UPDATE_SUCCESS.getMsg());
        map.put("url", "/sell/user/list");
        return new ModelAndView("common/success", map);
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid UserForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/user/index");
            return new ModelAndView("common/error", map);
        }
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        try {
            userInfoDTO = userInfoService.findOneByPhone(form.getUserPhone());
            if (userInfoDTO != null){
                map.put("msg", "帐号已存在，请登录");
                map.put("url", "/sell/user/index");
                return new ModelAndView("common/error", map);
            }else {
                BeanUtils.copyProperties(form, userInfoDTO);
                userInfoDTO.setUserId(KeyUtil.genUniqueKey());
                userInfoDTO.setOpenid("0000000000");
                userInfoDTO.setAccountStatus(AccountStatusEnum.NORMAL.getCode());
                userInfoService.save(userInfoDTO);
            }
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/user/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/user/list");
        return new ModelAndView("common/success", map);
    }

}
