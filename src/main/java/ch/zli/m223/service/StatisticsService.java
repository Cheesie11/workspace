package ch.zli.m223.service;

import ch.zli.m223.model.Entry;
import ch.zli.m223.model.TimeSummary;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.Duration;
import java.util.List;

@ApplicationScoped
public class StatisticsService {

    @Inject
    private EntityManager entityManager;

    public TimeSummary getDailyTimeSummary() {
        // Heutiges Datum
        LocalDate today = LocalDate.now();
        
        // Query, um alle Entries des heutigen Tages zu bekommen
        String queryStr = "SELECT e FROM Entry e WHERE e.checkIn >= :startOfDay AND e.checkIn < :endOfDay";
        TypedQuery<Entry> query = entityManager.createQuery(queryStr, Entry.class);
        query.setParameter("startOfDay", today.atStartOfDay());
        query.setParameter("endOfDay", today.plusDays(1).atStartOfDay());

        List<Entry> entries = query.getResultList();

        // Berechnung der gesamten Zeit für heute
        long totalMinutes = 0;
        for (Entry entry : entries) {
            Duration duration = Duration.between(entry.getCheckIn(), entry.getCheckOut());
            totalMinutes += duration.toMinutes();
        }

        // Rückgabe als TimeSummary Objekt
        return new TimeSummary(today, totalMinutes);
    }
}
