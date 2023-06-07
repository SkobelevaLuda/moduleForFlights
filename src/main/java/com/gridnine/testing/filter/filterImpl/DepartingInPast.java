package com.gridnine.testing.filter.filterImpl;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.flight.Flight;

import javax.swing.text.Segment;
import java.time.LocalDateTime;

public class DepartingInPast implements FlightFilter {
    @Override

    public boolean check(Flight flight) {
        for (Segment seg : flight.getSegments()) {
            if (seg.getDepartureDate().isBefore(LocalDateTime.now())) {
                return false;
            }
        }
        return true;
    }
}
