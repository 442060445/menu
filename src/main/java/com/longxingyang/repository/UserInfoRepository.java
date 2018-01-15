package com.longxingyang.repository;

import com.longxingyang.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by a4420 on 18/01/15.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String>{
    UserInfo findByOpenid(String openid);
}
