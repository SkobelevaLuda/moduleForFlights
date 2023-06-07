import com.gridnine.testing.filter.FlightFilter;

import com.gridnine.testing.filter.filterImpl.DepartsBeforeArrives;
import com.gridnine.testing.filter.filterImpl.MoreTwoHoursGroundTime;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;
import org.junit.Test;


import java.util.List;
public class MainTest {
    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    public void flightsCountAfterDepartingInPastFilterShouldBeOneLess() {
        FlightFilter flightFilter = new DepartingPast();
        long actual = flights.stream().filter(flightFilter::check).count();
        int expected = flights.size() - 1;
        Assert.isTrue(expected == actual,
                "Flights count after departing in past filter should be one less");
    }

    @Test
    public void flightsCountAfterDepartsBeforeArrivesFilterShouldBeOneLess() {
        FlightFilter flightFilter = new DepartsBeforeArrives();
        long actual = flights.stream().filter(flightFilter::check).count();
        int expected = flights.size() - 1;
        Assert.isTrue(expected == actual,
                "Flights count after departs before arrives filter should be one less");
    }

    @Test
    public void flightsCountAfterMoreTwoHoursGroundTimeFilterShouldBeTwoLess() {
        FlightFilter flightFilter = new MoreTwoHoursGroundTime();
        long actual = flights.stream().filter(flightFilter::check).count();
        int expected = flights.size() - 2;
        Assert.isTrue(expected == actual,
                "flightsCountAfterMoreTwoHoursGroundTimeFilterShouldBeTwoLess");
    }
}
