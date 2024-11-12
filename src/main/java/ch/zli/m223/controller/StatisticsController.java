package ch.zli.m223.controller;

import ch.zli.m223.model.TimeSummary;
import ch.zli.m223.service.StatisticsService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/statistics")
public class StatisticsController {

    @Inject
    StatisticsService statisticsService;

    @GET
    @Path("/timesummaries")
    @Produces(MediaType.APPLICATION_JSON)
    public TimeSummary getTimeSummary() {
        return statisticsService.getDailyTimeSummary();
    }
}
