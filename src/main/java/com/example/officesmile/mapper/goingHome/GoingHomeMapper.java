package com.example.officesmile.mapper.goingHome;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoingHomeMapper {

    void store(Long returningToWorkId);
}
