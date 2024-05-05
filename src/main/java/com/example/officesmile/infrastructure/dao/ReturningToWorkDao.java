package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.domain.entity.returningToWork.ReturningToWorkEntity;
import com.example.officesmile.infrastructure.dto.ReturningToWorkAndHomeDTO;
import com.example.officesmile.mapper.returningToWork.ReturningToWorkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReturningToWorkDao {

    private final ReturningToWorkMapper returningToWorkMapper;

    public void store(ReturningToWorkEntity returningToWork) {
        returningToWorkMapper.store(returningToWork);
    };

    public ReturningToWorkAndHomeDTO getReturningToWorkAndHomeNewStatus(Long userId) {
        return returningToWorkMapper.getReturningToWorkAndHomeNewStatus(userId);
    }
}
