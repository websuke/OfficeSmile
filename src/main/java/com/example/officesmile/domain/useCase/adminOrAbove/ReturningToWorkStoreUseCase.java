package com.example.officesmile.domain.useCase.adminOrAbove;

import com.example.officesmile.Repository.dao.ReturningToWorkDao;
import com.example.officesmile.domain.common.Util;
import com.example.officesmile.domain.entity.returningToWork.ReturningToWorkEntity;
import com.example.officesmile.presentation.returningToWork.ReturningToWorkForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReturningToWorkStoreUseCase {

    private final ReturningToWorkDao returningToWorkDao;

    public void invoke(ReturningToWorkForm form, String userId) {
        returningToWorkDao.store(ReturningToWorkEntity.toEntity(
                    null,
                    Long.parseLong(form.reasonSummaryId()),
                    form.reasonDetail(),
                    Util.now(),
                    Long.parseLong(userId)
                )
        );
    };
}