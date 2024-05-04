package com.example.officesmile.mapper.returningToWork;

import com.example.officesmile.domain.entity.returningToWork.ReturningToWorkEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReturningToWorkMapper {
    void store(ReturningToWorkEntity returningToWork);
}
