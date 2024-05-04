package com.example.officesmile.domain.entity.returningToWork;

public record ReturningToWorkEntity (
        Long returningToWorkId,
        Long reasonSummaryId,
        String reasonDetail,
        String dateTime,
        Long userId
){

    public static ReturningToWorkEntity toEntity(
            Long returningToWorkId,
            Long reasonSummaryId,
            String reasonDetail,
            String dateTime,
            Long userId
   ) {
        return new ReturningToWorkEntity(
                returningToWorkId,
                reasonSummaryId,
                reasonDetail,
                dateTime,
                userId
        );

    }
}
