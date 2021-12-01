package epam.nau.MVCPractice;

public class User {
    private String username;
    private int rollNum = 0;

    public User(String username){
        this.username = username;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public int getRollNum() {
        return rollNum;
    }

    public String getUsername() {
        return username;
    }
}
