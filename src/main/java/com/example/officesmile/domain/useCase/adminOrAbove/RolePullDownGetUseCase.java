package com.example.officesmile.domain.useCase.adminOrAbove;

import com.example.officesmile.Repository.dao.RoleDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolePullDownGetUseCase {

    private final RoleDao roleDao;

    @Transactional
    public List<String> invoke() {

        return roleDao.findAll();
    }
}
