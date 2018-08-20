package com.mst.db.service.impl;

import com.mst.db.dao.UserAuthMapper;
import com.mst.db.dao.UserDetailInfoMapper;
import com.mst.db.dao.UserInfoMapper;
import com.mst.db.domain.UserInfo;
import com.mst.db.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value="UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource
    private UserAuthMapper userAuthMapper;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private UserDetailInfoMapper userDetailInfoMapper;


    @Override
    public boolean addUserByRegist(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo)>0;
    }
}
