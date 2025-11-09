package com.aa.flightapiwrapper.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class FlightRequest {
    
    /** Origin airport code. */
    @NotBlank(message = "Origin is required")
    private String origin;
    
    /** Destination airport code. */
    @NotBlank(message = "Destination is required")
    private String destination;
    
    /** Requested departure date and time. */
    @NotNull(message = "Departure date is required")
    private LocalDateTime departureDate;
    
    /** Number of passengers. */
    private Integer passengers;

    public FlightRequest() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }
}

