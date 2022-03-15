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
        userMap.put("user", new User(1L, "user", "user", roleSet));
        userMap.put("admin", new User(2L, "admin", "admin", Collections.singleton((Role) roleSet.toArray()[1])));
        userMap.put("test", new User(3L, "test", "test", Collections.singleton((Role) roleSet.toArray()[0])));
        if (!userMap.containsKey(name)) {
            return null;
        }

        return userMap.get(name);
    }
}

