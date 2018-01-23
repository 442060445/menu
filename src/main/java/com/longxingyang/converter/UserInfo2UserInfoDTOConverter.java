package com.longxingyang.converter;

import com.longxingyang.dataobject.UserInfo;
import com.longxingyang.dto.UserInfoDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by a4420 on 18/01/23.
 */
public class UserInfo2UserInfoDTOConverter {

    public static UserInfoDTO convert(UserInfo userInfo){
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(userInfo, userInfoDTO, new String[]{"password"});
        return userInfoDTO;
    }

    public static List<UserInfoDTO> convert(List<UserInfo> userInfoList){
        return userInfoList.stream().map(e ->
                convert((e))
        ).collect(Collectors.toList());
    }
}
