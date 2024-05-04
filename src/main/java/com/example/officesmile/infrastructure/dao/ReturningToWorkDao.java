package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.domain.entity.returningToWork.ReturningToWorkEntity;
import com.example.officesmile.mapper.ReturningToWork.ReturningToWorkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReturningToWorkDao {

    private final ReturningToWorkMapper returningToWorkMapper;

    public void store(ReturningToWorkEntity returningToWork) {
        returningToWorkMapper.store(returningToWork);
    };
}
