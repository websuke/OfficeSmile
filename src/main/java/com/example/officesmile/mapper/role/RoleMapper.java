package com.example.officesmile.mapper.role;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<String> findAll();
}
