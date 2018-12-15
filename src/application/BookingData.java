package application; //bus data transfer object, its a template where the bus data is stored

import java.util.ArrayList;
import java.util.List;

public class BookingData {
	private final static BookingData instance = new BookingData();

    public static BookingData getInstance() {
        return instance;
    }
	
	public List<BusDto> bookings = new ArrayList<BusDto>();
	
	public void addBooking(BusDto booking)
	{
		bookings.add(booking);
		
	}
	public void removeBooking(BusDto booking) 
	{
		bookings.remove(booking);
	}
	public List<Integer> getOccupiedSeats()
	{
		List<Integer> occupiedSeats= new ArrayList<Integer>(); 
		for(BusDto bus: bookings)
		{
			occupiedSeats.addAll(bus.seats);
		}
		return occupiedSeats;
	}
	
}
