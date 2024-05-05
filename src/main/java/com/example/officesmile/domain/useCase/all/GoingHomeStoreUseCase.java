package com.example.officesmile.domain.useCase.all;

import com.example.officesmile.infrastructure.dao.GoingHomeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoingHomeStoreUseCase {

    private final GoingHomeDao goingHomeDao;

    public void store(Long returningToWorkId) {
        goingHomeDao.store(returningToWorkId);
    }
}
