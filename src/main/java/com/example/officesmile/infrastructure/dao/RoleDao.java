package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.mapper.role.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ロールDao
 */
@Repository
@RequiredArgsConstructor
public class RoleDao {

    private final RoleMapper roleMapper;

    /**
     * ロール全検索
     *
     * @return
     */
    public List<String> findAll() {
        return roleMapper.findAll();
    }
}
