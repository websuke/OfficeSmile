package com.example.officesmile.domain.useCase.adminOrAbove;

import com.example.officesmile.infrastructure.dao.ReturningToWorkDao;
import com.example.officesmile.infrastructure.dto.ReturningToWorkAndHomeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 帰社・帰宅最新状況取得シナリオ
 */
@Service
@RequiredArgsConstructor
public class ReturningToWorkAndHomeNewStatusGetUseCase {
    private final ReturningToWorkDao returningToWorkDao;

    public ReturningToWorkAndHomeDTO getReturningToWorkAndHomeNewStatus(Long userId) {
        return returningToWorkDao.getReturningToWorkAndHomeNewStatus(userId);
    }
}
