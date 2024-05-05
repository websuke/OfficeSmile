package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.domain.entity.returningToWork.ReturningToWorkEntity;
import com.example.officesmile.infrastructure.dto.ReturningToWorkAndHomeDTO;
import com.example.officesmile.mapper.returningToWork.ReturningToWorkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 帰宅Dao
 */
@Repository
@RequiredArgsConstructor
public class ReturningToWorkDao {

    private final ReturningToWorkMapper returningToWorkMapper;

    /**
     * 帰宅登録
     *
     * @param returningToWork
     */
    public void store(ReturningToWorkEntity returningToWork) {
        returningToWorkMapper.store(returningToWork);
    };

    /**
     * 帰社・帰宅最新状況取得
     *
     * @param userId
     * @return
     */
    public ReturningToWorkAndHomeDTO getReturningToWorkAndHomeNewStatus(Long userId) {
        return returningToWorkMapper.getReturningToWorkAndHomeNewStatus(userId);
    }
}
