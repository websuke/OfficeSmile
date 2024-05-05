package com.example.officesmile.infrastructure.dto;

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
