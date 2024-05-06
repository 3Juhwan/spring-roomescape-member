package roomescape.service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import roomescape.web.exception.DateFormat;

public record ReservationRequest(
        @NotBlank String name,
        @NotBlank @DateFormat String date,
        @NotNull @Positive Long timeId,
        @NotNull @Positive Long themeId
) {
}
