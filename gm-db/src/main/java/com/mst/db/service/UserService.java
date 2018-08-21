package com.mst.db.service;

import com.mst.db.domain.UserAuth;
import com.mst.db.domain.UserInfo;

public interface UserService {
    /**
     * 通过注册添加一条用户
     * @return
     */
    boolean addUserByRegistEmail(UserInfo userInfo,UserAuth userAuth);

    UserInfo getUserInfoByID(UserInfo userInfo);

    UserAuth getUserAuthByIdentifier(UserAuth userAuth);

}
