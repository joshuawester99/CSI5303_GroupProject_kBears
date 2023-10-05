public class Admin extends User{
    private int adminID;

    public Admin(String name, String userName, String password, int adminID) {
        super(name, userName, password);
        this.adminID = adminID;
    }

    public int getAdminID() {
        return adminID;
    }
    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }


}
