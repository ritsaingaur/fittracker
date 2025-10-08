package com.fitnessTracker.dto;

import java.util.List;

public class HomepageResponse {
    private String quote;
    private DashboardResponse todaySummary;
    private List<RoutineResponse> suggestedSchedule;

    // Getters and Setters
    public String getQuote() { return quote; }
    public void setQuote(String quote) { this.quote = quote; }

    public DashboardResponse getTodaySummary() { return todaySummary; }
    public void setTodaySummary(DashboardResponse todaySummary) { this.todaySummary = todaySummary; }

    public List<RoutineResponse> getSuggestedSchedule() { return suggestedSchedule; }
    public void setSuggestedSchedule(List<RoutineResponse> suggestedSchedule) { this.suggestedSchedule = suggestedSchedule; }
}
