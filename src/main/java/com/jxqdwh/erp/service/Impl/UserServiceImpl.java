package com.jxqdwh.erp.service.Impl;

import com.jxqdwh.erp.entity.Users;
import com.jxqdwh.erp.mapper.UsersMapper;
import com.jxqdwh.erp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UsersMapper userMapper;

    @Override
    public Users findUserById(int userId) {
        
        return  userMapper.findById(userId) ;
    }
}
