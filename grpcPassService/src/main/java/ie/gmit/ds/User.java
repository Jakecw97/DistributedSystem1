package ie.gmit.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class User {

    //Implemented @NotNull so forms cannot be left blank
    @NotNull
    private int userId;
    @NotNull
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String password;

    //Contains Getter classes only
    public User() {
    }//User

    //Constructor
    public User(int userId, String userName, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }//User(Constructor)

    @JsonProperty
    public int getUserId() {
        return userId;
    }//getUserId()

    @JsonProperty
    public String getUserName() {
        return userName;
    }//getUserName()

    @JsonProperty
    public String getEmail() {
        return email;
    }//getEmail()

    @JsonProperty
    public String getPassword() {
        return password;
    }//getPassword()
}//User

