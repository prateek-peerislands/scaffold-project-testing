package com.aa.flightapiwrapper.dto;

import java.time.LocalDateTime;
import java.util.List;

public class FlightResponse {
    
    /** Flight number identifier. */
    private String flightNumber;
    
    /** Origin airport code. */
    private String origin;
    
    /** Destination airport code. */
    private String destination;
    
    /** Scheduled departure time. */
    private LocalDateTime departureTime;
    
    /** Scheduled arrival time. */
    private LocalDateTime arrivalTime;
    
    /** Airline name. */
    private String airline;
    
    /** Flight price. */
    private Double price;
    
    /** Number of available seats. */
    private Integer availableSeats;
    
    /** List of amenities available on the flight. */
    private List<String> amenities;

    public FlightResponse() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
}

