package com.kg.ssm.simple.service.impl;

import com.kg.ssm.simple.dao.UserMapper;
import com.kg.ssm.simple.entity.User;
import com.kg.ssm.simple.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
