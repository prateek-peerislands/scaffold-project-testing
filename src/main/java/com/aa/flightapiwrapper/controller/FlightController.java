package com.aa.flightapiwrapper.controller;

import com.aa.flightapiwrapper.dto.FlightRequest;
import com.aa.flightapiwrapper.dto.FlightResponse;
import com.aa.flightapiwrapper.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/search")
    public ResponseEntity<List<FlightResponse>> searchFlights(@Valid @RequestBody FlightRequest request) {
        if (!flightService.validateFlightRequest(request)) {
            return ResponseEntity.badRequest().build();
        }
        
        List<FlightResponse> flights = flightService.searchFlights(request);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{flightNumber}")
    public ResponseEntity<FlightResponse> getFlight(@PathVariable String flightNumber) {
        FlightResponse flight = flightService.getFlightById(flightNumber);
        if (flight == null || flight.getFlightNumber() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flight);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Flight API is running");
    }
}

