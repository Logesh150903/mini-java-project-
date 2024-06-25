package project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOImpl implements UserDAO {
    private Map<Integer, User> users = new HashMap<>();
    private int idCounter = 0;

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getUserById(int userId) {
        return users.get(userId);
    }

    @Override
    public void createUser(User user) {
        user.setId(idCounter++);
        users.put(user.getId(), user);
    }

    @Override
    public void updateUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void deleteUser(int userId) {
        users.remove(userId);
    }
} 