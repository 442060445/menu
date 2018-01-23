package com.longxingyang.service;

import com.longxingyang.dataobject.UserInfo;
import com.longxingyang.dto.UserInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by a4420 on 18/01/23.
 */
public interface UserInfoService {
    //创建帐号
    UserInfoDTO save(UserInfoDTO userInfoDTO);

    //查询单个帐号
    UserInfoDTO findOne(String userId);

    //查询单个帐号
    UserInfoDTO findOneByPhone(String userPhone);

    //查询帐号列表
    Page<UserInfoDTO> findList(Pageable pageable);

    //停用账号
    UserInfoDTO disable(UserInfoDTO userInfoDTO);

    //恢复帐号状态
    UserInfoDTO enable(UserInfoDTO userInfoDTO);

}
