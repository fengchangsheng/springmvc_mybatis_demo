package com.fcs.user.service.impl;

import com.fcs.user.dao.UserInfoMapper;
import com.fcs.user.model.UserInfo;
import com.fcs.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lucare.Feng on 2016/1/24.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserById(int id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public List<UserInfo> getUsers() {
        return userInfoMapper.selectAll();
    }

    public int insert(UserInfo userInfo) {
        int result = userInfoMapper.insert(userInfo);

        System.out.println(result);
        return result;
    }
}
