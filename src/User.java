public class User {

    private String name;
    private String userName;
    private String password;

    public User(){
        this.name = "None";
    }
    public User(String name) {
        this.name = name;
        this.userName = "default";
        this.password = "default";

    }

    public User(String name, String userName, String password){
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
