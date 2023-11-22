
package room_interface;

public class RoomController {
        
    public RoomController() {
        Room_Listing RoomsFrame = new Room_Listing(); 
        RoomsFrame.setVisible(true);
        RoomsFrame.pack();
        RoomsFrame.setLocationRelativeTo(null); // center
    }

}