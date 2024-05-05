package com.example.officesmile.domain.useCase.general;

import com.example.officesmile.infrastructure.dao.GoingHomeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 帰宅登録シナリオ
 */
@Service
@RequiredArgsConstructor
public class GoingHomeStoreUseCase {

    private final GoingHomeDao goingHomeDao;

    public void store(Long returningToWorkId) {
        goingHomeDao.store(returningToWorkId);
    }
}
