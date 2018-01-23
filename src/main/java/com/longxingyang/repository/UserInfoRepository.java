package com.longxingyang.repository;

import com.longxingyang.dataobject.UserInfo;
import com.longxingyang.dto.UserInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by a4420 on 18/01/15.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String>{
    UserInfo findByUserId(String userId);

    UserInfo findByUserPhone(String UserPhone);
}
