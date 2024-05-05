package com.example.officesmile.infrastructure.dto;

/**
 * 帰社・帰宅DTO
 *
 * @param returningToWorkId
 * @param reasonSummaryId
 * @param reasonDetail
 * @param returningToWorkDateTime
 * @param userId
 * @param goingHomeId
 * @param goingHomeDateTime
 */
public record ReturningToWorkAndHomeDTO (
        String returningToWorkId,
        String reasonSummaryId,
        String reasonDetail,
        String returningToWorkDateTime,
        String userId,
        String goingHomeId,
        String goingHomeDateTime
) {
}
