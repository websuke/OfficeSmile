package com.example.officesmile.presentation.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserForm (
        @NotBlank
        @Size(max = 128)
        String authId,
        @NotBlank
        @Size(max = 128)
        String password,
        @NotBlank
        @Size(max = 256)
        String userName,
        @NotBlank
        @Pattern(regexp = "GENERAL|ADMIN|SUPER_USER", message = "一般, 管理者, スーパーユーザーのいずれかを入力して下さい。")
        String authority,
        @NotBlank
//      TODO: @DBの値を見て存在しない場合にエラーとしたいためカスタムバリデーションを作成する。
        String roleId
){

}
