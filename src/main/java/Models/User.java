package Models;

public class User {
    private String email;
    private String password;
    private String fullName;
    private String mobile;
    private String membershipStartDate;

    public User(String email, String password, String fullName, String mobile, String membershipStartDate) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.mobile = mobile;
        this.membershipStartDate = membershipStartDate;
    }
    public User() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }
}
