package com.longxingyang.service.Impl;

import com.longxingyang.converter.UserInfo2UserInfoDTOConverter;
import com.longxingyang.dataobject.UserInfo;
import com.longxingyang.dto.UserInfoDTO;
import com.longxingyang.enums.AccountStatusEnum;
import com.longxingyang.enums.ResultEnum;
import com.longxingyang.exception.SellException;
import com.longxingyang.repository.UserInfoRepository;
import com.longxingyang.service.UserInfoService;
import com.longxingyang.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by a4420 on 18/01/23.
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    UserInfoRepository repository;

    @Override
    public UserInfoDTO save(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDTO, userInfo);
        repository.save(userInfo);
        userInfoDTO.setPassword("");
        return userInfoDTO;
    }

    @Override
    public UserInfoDTO findOne(String userId) {
        return UserInfo2UserInfoDTOConverter.convert(repository.findOne(userId));
    }

    @Override
    public Page<UserInfoDTO> findList(Pageable pageable) {
        Page<UserInfo> userInfoPage= repository.findAll(pageable);
        List<UserInfoDTO> userInfoDTOList = UserInfo2UserInfoDTOConverter.convert(userInfoPage.getContent());
        return new PageImpl<UserInfoDTO>(userInfoDTOList, pageable, userInfoPage.getTotalElements());
    }

    @Override
    public UserInfoDTO disable(UserInfoDTO userInfoDTO) {
        if(userInfoDTO.getAccountStatus().equals(AccountStatusEnum.CANCEL.getCode())){
            log.error("【帐号管理】帐号已停用，无需重复操作, UserId={}, AccountStatus={}", userInfoDTO.getUserId(), userInfoDTO.getAccountStatus());
            throw new SellException(ResultEnum.ACCOUNT_STATUS_ERROR);
        }
        UserInfo userInfo = repository.findOne(userInfoDTO.getUserId());
        userInfo.setAccountStatus(AccountStatusEnum.CANCEL.getCode());
        UserInfo result = repository.save(userInfo);
        if (result == null){
            log.error("【帐号管理】更新失败, user={}", userInfo);
            throw new SellException(ResultEnum.ACCOUNT_UPDATE_FAIL);
        }

        return userInfoDTO;
    }

    @Override
    public UserInfoDTO enable(UserInfoDTO userInfoDTO) {
        if(userInfoDTO.getAccountStatus().equals(AccountStatusEnum.NORMAL.getCode())){
            log.error("【帐号管理】帐号正常，无需重复操作, UserId={}, AccountStatus={}", userInfoDTO.getUserId(), userInfoDTO.getAccountStatus());
            throw new SellException(ResultEnum.ACCOUNT_STATUS_ERROR);
        }
        UserInfo userInfo = repository.findOne(userInfoDTO.getUserId());
        userInfo.setAccountStatus(AccountStatusEnum.NORMAL.getCode());
        UserInfo result = repository.save(userInfo);
        if (result == null){
            log.error("【帐号管理】更新失败, user={}", userInfo);
            throw new SellException(ResultEnum.ACCOUNT_UPDATE_FAIL);
        }

        return userInfoDTO;
    }

    @Override
    public UserInfoDTO findOneByPhone(String userPhone) {
        return UserInfo2UserInfoDTOConverter.convert(repository.findByUserPhone(userPhone));
    }
}
