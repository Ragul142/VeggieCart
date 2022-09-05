import java.util.Map;
import java.util.regex.Pattern;

/**
 * <UserService> Service class of User of Vegetables buying app
 *
 * @version      JDK 1.8.0_341 05_Sep_2022
 * @author       Ragul_V
 */
public class UserService {
    private UserRepository userRepository = new UserRepository();

    /**
     * Receive the User object for pass it to repository to add
     *
     * @param userId Key for HashMap as String
     * @param user value for HashMap as User object
     *
     * @return true if user details added in users else false
     */
    public boolean createUser(String userId, User user) {
        return userRepository.saveUser(userId, user);
    }

    /**
     * Receive the user object for pass it to repository to remove
     *
     * @param userId Key for HashMap as String 
     *
     * @return true if user object removed in users else false
     */
    public boolean removeUser(String userId) {
        return userRepository.deleteUser(userId);
    } 

    /**
     * pass the User collection to controller
     *
     * @return Users as HashMap
     */        
    public Map<String, User> getUsers() {
        return userRepository.getUsers();
    }
    
    /**
     * Check the user name whether in valid format which matches pattern
     *
     * @param userName as string 
     *
     * @return true or false boolean  
     */
    public boolean isValidUserName(String userName) {
        return (Pattern.matches("^[A-Z][a-zA-Z\\s]{3,30}$", userName));
    }

    /**
     * Check the mailId whether in valid format which matches pattern
     *
     * @param mailId as string 
     *
     * @return true or false boolean  
     */    
    public boolean isValidMailId(String mailId) {
        return (Pattern.matches("[A-Za-z0-9.]{5,30}@[A-Za-z0-9.]{5,30}", mailId)); 
    }

    /**
     * Check the phoneNo whether in valid format which matches pattern
     *
     * @param phoneNo as String 
     *
     * @return true or false boolean  
     */

    public boolean isValidPhoneNo(String phoneNo) {
        return (Pattern.matches("[+]?[9]?[1]?[0]?[6789][0-9]{9}", phoneNo));
    }

    /**
     * Check the location whether in valid format which matches pattern
     *
     * @param location as string 
     *
     * @return true or false boolean  
     */
    
    public boolean isValidLocation(String location) {
        return (Pattern.matches("^[A-Z][a-zA-Z\\s]{3,30}$", location));
    }
    
    /**
     * Check the pincode whether in valid format which matches pattern
     *
     * @param pincode as int 
     *
     * @return true or false boolean  
     */

    public boolean isValidPincode(int pincode) {
        return Pattern.matches("^[0-9]{6}$", Integer.toString(pincode));
    }

    /**
     * Check the userId whether in valid format which matches pattern
     *
     * @param userId as string 
     *
     * @return true or false boolean  
     */
    
    public boolean isValidUserId(String userId) {
        return (Pattern.matches("^[A-Za-z]{5,20}[0-9]{1,10}$", userId) &&
                (!getUsers().containsKey(userId)));
    }
 
    /**
     * Check the password whether in valid format which matches pattern
     *
     * @param password as string 
     *
     * @return true or false boolean  
     */

    public boolean isValidPassword(String password) {
        return (Pattern.matches("^[^\\s]{5,30}$", password));
    }
    
    /**
     * Checks whether the customer sign in details correct or not
     *
     * @param userId as String
     * @param password as String
     *
     * @return true if it is valid else false
     */
    public boolean isValidCustomer(String userId, String password) {
        for(User user: getUsers().values()) {
            if(user.getUserId().equals(userId) 
                && user.getPassword().equals(password)
                && user.getRole().equals("Customer")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the admin sign in details correct or not
     *
     * @param userId as String
     * @param password as String
     *
     * @return true if it is valid else false
     */    
    public boolean isValidAdmin(String userId, String password) {
        for(User user: getUsers().values()) {
            if(user.getUserId().equals(userId) 
                && user.getPassword().equals(password)
                && user.getRole().equals("Admin")) {
                return true;
            }
        }
        return false;
    }

}