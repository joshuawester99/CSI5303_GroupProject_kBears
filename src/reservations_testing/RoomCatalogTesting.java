package reservations_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import driver.RoomCatalog;
import driver.Room;

class RoomCatalogTesting {
	
	@Test
	void test_ViewRoom() {
		RoomCatalog rooms = new RoomCatalog();
		Room room = new Room("52", false, "queen", 2, "comfort", 100);
		rooms.putRoom("52", room);
		
		String test = "Room Number: " + "52" 
    			+ "\nSmoking: " + "false" 
    			+ "\nBed Number: " + "2"
    			+ "\nBed Type: " + "queen"
    			+ "\nQuality: " + "comfort";
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		rooms.viewRoom("52");
		assertEquals(test, outContent.toString());
	}
	
	@Test
	void test_getMatchingRooms() {
		RoomCatalog rooms = new RoomCatalog();
		Room room = new Room("52", false, "queen", 2, "comfort", 100);
		rooms.putRoom("52", room);

		assertEquals(room, rooms.getMatchingRooms(false, "queen", 2, "comfort").get(0));
	}
	
}
