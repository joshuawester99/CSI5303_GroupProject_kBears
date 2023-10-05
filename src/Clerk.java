public class Clerk extends User{

    private String employeeID;

    public Clerk(String name, String employeeID) {
        super(name);
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }


}
