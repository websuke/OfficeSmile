package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.mapper.goingHome.GoingHomeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GoingHomeDao {
    private final GoingHomeMapper goingHomeMapper;

    public void store(Long returningToWorkId){
        goingHomeMapper.store(returningToWorkId);
    }
}
