package com.example.officesmile.presentation.returningToWork;

import jakarta.validation.constraints.NotBlank;

public record ReturningToWorkForm (
        @NotBlank
        // TODO: DBの値を見てから存在しない場合エラーとするカスタムバリデーションの作成
        String reasonSummaryId,
        String reasonDetail
) {
}
