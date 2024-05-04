package com.example.officesmile.mapper.userRole;

import com.example.officesmile.domain.entity.userRole.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {

    void store(UserRoleEntity userRoleEntity);
}
