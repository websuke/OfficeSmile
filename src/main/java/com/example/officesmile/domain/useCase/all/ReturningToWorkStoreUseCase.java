package com.example.officesmile.domain.useCase.all;

import com.example.officesmile.domain.common.Util;
import com.example.officesmile.domain.entity.returningToWork.ReturningToWorkEntity;
import com.example.officesmile.infrastructure.dao.ReturningToWorkDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 帰社登録シナリオ
 */
@Service
@RequiredArgsConstructor
public class ReturningToWorkStoreUseCase {

    private final ReturningToWorkDao returningToWorkDao;

    public void invoke(String reasonSummaryId, String reasonDetail, String userId) {
        returningToWorkDao.store(
                ReturningToWorkEntity.toEntity(
                    null,
                    Long.parseLong(reasonSummaryId),
                    reasonDetail,
                    Util.now(),
                    Long.parseLong(userId)
                )
        );
    };
}