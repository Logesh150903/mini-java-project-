package project;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(int userId);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
}
