package application; //bus data transfer object, its a template where the bus data is stored

import java.util.ArrayList;
import java.util.List;

public class BusDto {

	public String name;
	
	public String departureLocation;
	
	public String destination;
	
	public String departureTime;
	
	public Integer id;
	
	public Integer fare;
	
	public List<Integer> seats = new ArrayList<Integer>();
	
	public List<Integer> bookedSeats = new ArrayList<Integer>();
	
	public BusDto(String name, String destination, String departureTime, Integer fare, Integer id) {
		this.name = name;
		this.destination = destination;
		this.departureTime = departureTime;
		this.fare = fare;
		this.id = id;
	}
	
	public void bookSeat(Integer seat) {
		bookedSeats.add(seat);
	}
}
