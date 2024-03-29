package com.example.demo.mapper;


import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_modified,gmt_create) values (#{name},#{accountId},#{token},#{gmtModified},#{gmtCreate})")
    void insert(User user);
}
