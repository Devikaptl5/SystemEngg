package application;

import java.util.ArrayList;
import java.util.List;

public class PersistanceData {

	public List<BusDto> buses = new ArrayList<>(); //bus data is stored in array
	
	public List<BookedSeat> bookedSeat = new ArrayList<>();
	
	public PersistanceData() {
		BusDto bus1 = new BusDto("Amsterdam", "Amsterdam", 19); // name of buses, route and prices are stored
		BusDto bus2 = new BusDto("Brussels", "Brussels", 24);
		BusDto bus3 = new BusDto("Paris", "Paris", 29);
		BusDto bus4 = new BusDto("Vienna", "Vienna", 29);
		BusDto bus5 = new BusDto("Budapest", "Budapest", 49);
		BusDto bus6 = new BusDto("Prague", "Prague", 39);
		
		buses.add(bus1); // Creating bus with seats.
		buses.add(bus2);
		buses.add(bus3);
		buses.add(bus4);
		buses.add(bus5);
		buses.add(bus6);
	}
}
