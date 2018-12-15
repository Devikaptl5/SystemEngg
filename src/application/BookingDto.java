package application;

import java.util.List;

public class BookingDto {
	private BusDto bus;
	private String bookingId;
	private List<String> bookedSeats;
	
	public BookingDto(BusDto dto, String id, List<String> seats) {
		bus = dto;
		bookingId = id;
		bookedSeats = seats;
	}
	
	public BusDto getBus() {
		return bus;
	}
	
	public String getBookingId() {
		return bookingId;
	}
	
	public List<String> getBookedSeats() {
		return bookedSeats;
	}
}
