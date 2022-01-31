package bd.com.letsride.user.models.requestModels;

public class SaveUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String Password;
    private String profilePhoto;

    public SaveUserRequest(String firstName, String lastName, String email, String userName, String password, String profilePhoto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        Password = password;
        this.profilePhoto = profilePhoto;
    }
}
