package roomescape.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import roomescape.service.dto.validation.DateFormat;

public record ReservationAdminRequest(
        @NotBlank String name,
        @NotBlank @DateFormat String date,
        @NotNull @Positive Long timeId,
        @NotNull @Positive Long themeId
) {
}