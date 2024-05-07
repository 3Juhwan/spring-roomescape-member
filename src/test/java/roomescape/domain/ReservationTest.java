package roomescape.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThatCode;

class ReservationTest {
    @DisplayName("예약을 생성한다")
    @Test
    void when_createReservation_then_created() {
        assertThatCode(() -> new Reservation("피케이", Fixture.tomorrow, Fixture.now, Fixture.theme))
                .doesNotThrowAnyException();
    }

    private static class Fixture {
        static final LocalDate tomorrow = LocalDate.now().plusDays(1);
        static final ReservationTime now = new ReservationTime(LocalTime.now());
        static final Theme theme = new Theme("테마", "테마 설명", "https://thumbnail.jpg");
    }

}