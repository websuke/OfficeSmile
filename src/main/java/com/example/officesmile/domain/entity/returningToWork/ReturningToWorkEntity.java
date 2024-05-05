package com.example.officesmile.domain.entity.returningToWork;

/**
 * 帰社エンティティ
 *
 * @param returningToWorkId
 * @param reasonSummaryId
 * @param reasonDetail
 * @param userId
 */
public record ReturningToWorkEntity (
        Long returningToWorkId,
        Long reasonSummaryId,
        String reasonDetail,
        Long userId
){

    public static ReturningToWorkEntity toEntity(
            Long returningToWorkId,
            Long reasonSummaryId,
            String reasonDetail,
            Long userId
   ) {
        return new ReturningToWorkEntity(
                returningToWorkId,
                reasonSummaryId,
                reasonDetail,
                userId
        );

    }
}
