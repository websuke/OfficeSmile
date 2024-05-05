package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.mapper.goingHome.GoingHomeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 帰社Dao
 */
@Repository
@RequiredArgsConstructor
public class GoingHomeDao {
    private final GoingHomeMapper goingHomeMapper;

    /**
     * 帰社登録
     *
     * @param returningToWorkId
     */
    public void store(Long returningToWorkId){
        goingHomeMapper.store(returningToWorkId);
    }
}
