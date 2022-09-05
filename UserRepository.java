import java.util.HashMap;
import java.util.Map;

/**
 * <UserRepository> Repository class for user in Vegetables buying app
 *
 * @version      JDK 1.8.0_341 05_Sep_2022
 * @author       Ragul_V
 */
public class UserRepository {
    
    private Map<String, User> users = new HashMap<>();
    
    /**
     * add the user object in the Users collection
     *
     * @param userId as String
     * @param user   User class object
     *
     * @return true
     */    
    public boolean saveUser(String userId, User user) {
        users.put(userId, user);
        return true;
    }
    
    /**
     * remove the user object in the Users collection
     *
     * @param userId as String
     *
     * @return true
     */    
    public boolean deleteUser(String userId) {
        users.remove(userId);
        return true;
    }
    
    /**
     * pass the Users collections
     *
     * @return Users as Map 
     */        
    public Map<String, User> getUsers() {
        return users;
    }
}