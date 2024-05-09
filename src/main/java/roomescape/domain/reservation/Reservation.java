package roomescape.domain.reservation;

import roomescape.domain.exception.InvalidDomainObjectException;
import roomescape.domain.theme.Theme;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Reservation {
    private final Long id;
    private final Name name;
    private final ReservationDate date;
    private final ReservationTime time;
    private final Theme theme;

    public Reservation(String name, LocalDate date, ReservationTime time, Theme theme) {
        this(null, new Name(name), new ReservationDate(date), time, theme);
    }

    public Reservation(Long id, Name name, ReservationDate date, ReservationTime time, Theme theme) {
        validate(name, date, time, theme);
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.theme = theme;
    }

    private void validate(Name name, ReservationDate date, ReservationTime time, Theme theme) {
        validateName(name);
        validateDate(date);
        validateTime(time);
        validateTheme(theme);
    }

    private void validateName(Name name) {
        if (Objects.isNull(name)) {
            throw new InvalidDomainObjectException("name must not be null");
        }
    }

    private void validateDate(ReservationDate date) {
        if (Objects.isNull(date)) {
            throw new InvalidDomainObjectException("date must not be null");
        }
    }

    private void validateTime(ReservationTime time) {
        if (Objects.isNull(time)) {
            throw new InvalidDomainObjectException("time must not be null");
        }
    }

    private void validateTheme(Theme theme) {
        if (Objects.isNull(theme)) {
            throw new InvalidDomainObjectException("theme must not be null");
        }
    }

    public boolean hasSameTheme(Reservation reservation) {
        return this.theme.equals(reservation.theme);
    }

    public boolean hasSameDateTime(Reservation reservation) {
        return this.getDateTime().equals(reservation.getDateTime());
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public ReservationDate getDate() {
        return date;
    }

    public ReservationTime getTime() {
        return time;
    }

    public Theme getTheme() {
        return theme;
    }

    public LocalDateTime getDateTime() {
        return LocalDateTime.of(this.date.getStartAt(), this.time.getStartAt());
    }

    public boolean isBeforeNow() {
        LocalDateTime reservationDataTime = LocalDateTime.of(date.getStartAt(), time.getStartAt());
        LocalDateTime currentDateTime = LocalDateTime.now();
        return reservationDataTime.isBefore(currentDateTime);
    }
}