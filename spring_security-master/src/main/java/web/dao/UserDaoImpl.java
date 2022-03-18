package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

//    private final Map<String, User> userMap = Collections.singletonMap("user",
//            new User(1L, "user", "user", Collections.singleton(new Role(1L, "ROLE_ADMIN")))); // name - уникальное значение, выступает в качестве ключа Map

    private final Map<String, User> userMap = new HashMap<>();
    private final Set<Role> roleSet = new HashSet<>();

    @Override
    public User getUserByName(String name) {
        roleSet.add(new Role(1L, "ROLE_USER"));
        roleSet.add(new Role(2L, "ROLE_ADMIN"));
        roleSet.add(new Role(3L, "ROLE_STUDENT"));
        userMap.put("user", new User(1L, "user", "user", roleSet));
        userMap.put("admin", new User(2L, "admin", "admin", Collections.singleton((Role) roleSet.toArray()[1])));
        userMap.put("test", new User(3L, "test", "test", Collections.singleton((Role) roleSet.toArray()[0])));
        userMap.put("none", new User(4L, "none", "none", Collections.singleton((Role) roleSet.toArray()[2])));
        if (!userMap.containsKey(name)) {
            return null;
        }

        return userMap.get(name);
    }

    @Override
    public void createUser(User user) {
        userMap.put(user.getUsername(), user);
    }

    @Override
    public List<User> readUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getUserById(Long id) {
        for (User user : userMap.values()) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void updateUser(Long id, User user) {
        for (User oldUser : userMap.values()) {
            if (oldUser.getId().equals(id)) {
                userMap.remove(oldUser.getUsername());
                userMap.put(user.getUsername(), user);
            }
        }
    }

    @Override
    public void deleteUser(Long id) {
        for (User user : userMap.values()) {
            if (user.getId().equals(id)) {
                userMap.remove(user.getUsername());
            }
        }
    }
}

