package application;

import java.util.ArrayList;
import java.util.List;

public class PersistanceData {

	public List<BusDto> buses = new ArrayList<>(); // bus data is stored in array
	public List<CityDto> cities = new ArrayList<>();
	private List<BookingDto> confirmedBookings = new ArrayList<BookingDto>();

	public List<BookedSeat> bookedSeat = new ArrayList<>();

	public PersistanceData() {
		
		buses.add(new BusDto("Amsterdam - Bus", "Amsterdam", "21:00", 19, 1, 1));
		buses.add(new BusDto("Amsterdam - Bus", "Amsterdam", "21:00", 19, 1, 2));
		buses.add(new BusDto("Amsterdam - Bus", "Amsterdam", "21:00", 19, 1, 3));
		buses.add(new BusDto("Brussels - Bus", "Brussels", "19:00", 24, 2, 4));
		buses.add(new BusDto("Brussels - Bus", "Brussels", "19:00", 24, 2, 5));
		buses.add(new BusDto("Brussels - Bus", "Brussels", "19:00", 24, 2, 6));
		
		cities.add(new CityDto("Amsterdam",1));
		cities.add(new CityDto("Brussels",2));
		
		
		/*buses.add(new BusDto("Paris - Bus", "Paris", "20:00", 29, 3, 1));
		buses.add(new BusDto("Paris - Bus", "Paris", "20:00", 29, 3, 2));
		buses.add(new BusDto("Paris - Bus", "Paris", "20:00", 29, 3, 3));
		
		buses.add(new BusDto("Vienna - Bus", "Vienna", "03:00", 29, 4, 1));
		buses.add(new BusDto("Vienna - Bus", "Vienna", "03:00", 29, 4, 2));
		buses.add(new BusDto("Vienna - Bus", "Vienna", "03:00", 29, 4, 3));
		
		buses.add(new BusDto("Budapest - Bus", "Budapest", "02:00", 49, 5, 1));
		buses.add(new BusDto("Budapest - Bus", "Budapest", "02:00", 49, 5, 2));
		buses.add(new BusDto("Budapest - Bus", "Budapest", "02:00", 49, 5, 3));
		
		buses.add(new BusDto("Prague - Bus", "Prague", "05:00", 39, 6, 1));
		buses.add(new BusDto("Prague - Bus", "Prague", "05:00", 39, 6, 2));
		buses.add(new BusDto("Prague - Bus", "Prague", "05:00", 39, 6, 3));*/
		
	}

	public List<BookingDto> getConfirmedBookings() {
		return confirmedBookings;
	}

	public void addConfirmedBooking(BookingDto booking) {
		confirmedBookings.add(booking);
	}

	public BusDto findBus(Integer id) {
		BusDto selectedBus = null;
		for (BusDto bus : buses) {
			if (bus.id == id) {
				return bus;
			}
		}
		System.out.println("Selected bus: " + selectedBus);
		return selectedBus;
	}

	public BookingDto findBooking(String id) {
		BookingDto booking = null;
		for (BookingDto b : confirmedBookings) {
			if (b.getBookingId().equals(id)) {
				return b;
			}
		}
		return booking;
	}

	public List<BookingDto> getAllBookinsForBus(Integer busId) {
		List<BookingDto> busBookings = new ArrayList<BookingDto>();

		for (BookingDto booking : confirmedBookings) {
			if (booking.getBus().id == busId) {
				busBookings.add(booking);
			}
		}

		return busBookings;
	}

	public BookingDto findBookingById(String bookingId) {
		BookingDto confirmedBooking = null;
		for (BookingDto booking : confirmedBookings) {
			if (booking.getBookingId().equals(bookingId)) {
				return booking;
			}
		}
		return confirmedBooking;
	}

	public List<String> findOccupiedSeats(Integer id) {
		List<String> occupiedSeats = new ArrayList<String>();
		List<BookingDto> bookings = getAllBookinsForBus(id);
		for (BookingDto booking : bookings) {
			for (String seat : booking.getBookedSeats()) {
				occupiedSeats.add(seat);
			}
		}
		System.out.println(occupiedSeats);
		return occupiedSeats;
	}

	public Boolean cancelBooking(String bookingId) {
		BookingDto booking = findBooking(bookingId);
		if (booking != null) {
			confirmedBookings.remove(booking);
			return true;
		}
		return false;
	}
	
	public void cancelBooking(BookingDto booking) {
		confirmedBookings.remove(booking);
	}
}
