package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.mapper.role.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RoleDao {

    private final RoleMapper roleMapper;

    public List<String> findAll() {
        return roleMapper.findAll();
    }
}
