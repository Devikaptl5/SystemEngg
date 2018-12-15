package application; //bus data transfer object, its a template where the bus data is stored

import java.util.ArrayList;
import java.util.List;

public class BusDto {

	public String name;
	
	public String departureLocation;
	
	public Integer fare;
	
	public List<Integer> seats = new ArrayList<Integer>();
	
	public BusDto(String name, String departureLocation, Integer fare) {
		this.name = name;
		this.departureLocation = departureLocation;
		this.fare = fare;
		for (Integer seatNumber=1; seatNumber<= 4; seatNumber++) {
			seats.add(seatNumber);
		}
	}
}
