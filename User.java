/**
 * <User>      POJO Class of User 
 *
 * @version    JDK 1.8.0_341 05_Sep_2022
 * @author     Ragul_V
 */
public class User {
    private int pincode;
    private String phoneNo;
    private String userName;    
    private String mailId;
    private String location;
    private String userId;
    private String password;
    private String role;
    
    User(String userName, String mailId, String phoneNo, String location,
         int pincode, String role, String userId, String password) {
        this.pincode = pincode;
        this.phoneNo = phoneNo;
        this.userName = userName;    
        this.mailId = mailId;
        this.location = location;
        this.role = role;
        this.userId = userId; 
        this.password = password;    
    }
    
    public int getPincode() {
        return pincode;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMailId() {
        return mailId;
    }
    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getRole() {
        return role;
    }
    public void setRole() {
        this.role = role;
    }
    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n1. Name: ").append(userName) 
                .append("\n2. MailId: ").append(mailId)
                .append("\n3. Phone number: ").append(phoneNo) 
                .append("\n4. Location: ").append(location) 
                .append("\n5. Pincode: ").append(pincode);
        return stringBuilder.toString();
    }

}
