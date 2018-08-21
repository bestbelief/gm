package com.mst.db.service.impl;

import com.mst.db.dao.UserAuthMapper;
import com.mst.db.dao.UserDetailInfoMapper;
import com.mst.db.dao.UserInfoMapper;
import com.mst.db.domain.UserAuth;
import com.mst.db.domain.UserAuthExample;
import com.mst.db.domain.UserInfo;
import com.mst.db.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public boolean addUserByRegistEmail(UserInfo userInfo,UserAuth userAuth){
        userInfoMapper.insertSelective(userInfo);
        userAuth.setUserId(userInfo.getId());
        userAuthMapper.insertSelective(userAuth);
        return true;
    }

    @Override
    public UserInfo getUserInfoByID(UserInfo userInfo) {
        return userInfoMapper.selectByPrimaryKey(userInfo.getId());
    }

    @Override
    public UserAuth getUserAuthByIdentifier(UserAuth userAuth) {
        UserAuthExample userAuthExample=new UserAuthExample();
        userAuthExample.or().andIdentifierEqualTo(userAuth.getIdentifier());
        return userAuthMapper.selectOneByExample(userAuthExample);
    }
}
