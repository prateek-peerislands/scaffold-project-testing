package com.aa.flightapiwrapper.service;

import com.aa.flightapiwrapper.dto.FlightRequest;
import com.aa.flightapiwrapper.dto.FlightResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    public List<FlightResponse> searchFlights(FlightRequest request) {
        List<FlightResponse> flights = new ArrayList<>();
        
        // Mock flight data for testing
        for (int i = 1; i <= 3; i++) {
            FlightResponse flight = new FlightResponse();
            flight.setFlightNumber("AA" + String.format("%04d", i * 100));
            flight.setOrigin(request.getOrigin());
            flight.setDestination(request.getDestination());
            flight.setDepartureTime(request.getDepartureDate());
            flight.setArrivalTime(request.getDepartureDate().plusHours(2 + i));
            flight.setAirline("American Airlines");
            flight.setPrice(299.99 + (i * 50.0));
            flight.setAvailableSeats(150 - (i * 10));
            
            List<String> amenities = new ArrayList<>();
            amenities.add("WiFi");
            amenities.add("Entertainment");
            if (i > 1) {
                amenities.add("Meal");
            }
            flight.setAmenities(amenities);
            
            flights.add(flight);
        }
        
        return flights;
    }

    public FlightResponse getFlightById(String flightNumber) {
        FlightResponse flight = new FlightResponse();
        flight.setFlightNumber(flightNumber);
        flight.setOrigin("JFK");
        flight.setDestination("LAX");
        flight.setDepartureTime(LocalDateTime.now().plusDays(1));
        flight.setArrivalTime(LocalDateTime.now().plusDays(1).plusHours(6));
        flight.setAirline("American Airlines");
        flight.setPrice(399.99);
        flight.setAvailableSeats(120);
        
        List<String> amenities = new ArrayList<>();
        amenities.add("WiFi");
        amenities.add("Entertainment");
        amenities.add("Meal");
        amenities.add("Priority Boarding");
        flight.setAmenities(amenities);
        
        return flight;
    }

    public boolean validateFlightRequest(FlightRequest request) {
        if (request.getOrigin() == null || request.getOrigin().trim().isEmpty()) {
            return false;
        }
        if (request.getDestination() == null || request.getDestination().trim().isEmpty()) {
            return false;
        }
        if (request.getDepartureDate() == null) {
            return false;
        }
        if (request.getDepartureDate().isBefore(LocalDateTime.now())) {
            return false;
        }
        return true;
    }
}

