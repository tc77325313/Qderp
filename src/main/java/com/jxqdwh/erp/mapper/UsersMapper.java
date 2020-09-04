package com.jxqdwh.erp.mapper;


import com.jxqdwh.erp.entity.Users;

public interface UsersMapper {

    public Users findByName(String name);

    public Users  findById(Integer id);
}
