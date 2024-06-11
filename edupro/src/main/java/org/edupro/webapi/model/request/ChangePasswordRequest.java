package org.edupro.webapi.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordRequest {

    @NotEmpty
    @Size(min = 5)
    private String currentPassword;

    @NotEmpty
    @Size(min = 5)
    private String newPassword;

    @NotEmpty
    @Size(min = 5)
    private String confirmationPassword;
}
