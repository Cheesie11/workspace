package ch.zli.m223.model;

import java.time.LocalDate;

public class TimeSummary {
    private LocalDate date;
    private long totalMinutes;

    public TimeSummary(LocalDate date, long totalMinutes) {
        this.date = date;
        this.totalMinutes = totalMinutes;
    }

    // Getter und Setter
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(long totalMinutes) {
        this.totalMinutes = totalMinutes;
    }
}
