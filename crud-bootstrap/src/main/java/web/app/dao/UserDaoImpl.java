package web.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.app.model.Role;
import web.app.model.User;
import web.app.service.DiscordService;
import web.app.service.RoleService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DiscordService discordService;

    @Autowired
    private RoleService roleService;

    @Override
    public User getUserByEmail(String email) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("select user from User user where user.email=:email")
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public User getUserById(Long id) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("select user from User user where user.id=:id")
                .setParameter("id", id)
                .uniqueResult();
//        return (User) sessionFactory.getCurrentSession().get(String.valueOf(id), User.class);
    }

    @Override
    public void createUser(User user) {
        Set<Role> roleSet = new HashSet<>();

        for (Role role : user.getRoles()) {
            roleSet.add((Role) sessionFactory.getCurrentSession()
                    .createQuery("select role from Role role where role.name=:name")
                    .setParameter("name", role.getName())
                    .uniqueResult());
        }
        user.setRoles(roleSet);
        user.setRequest(false);
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> readUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User")
                .getResultList();
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User userToBeUpdate = getUserById(id);
        Set<Role> roleSet = new HashSet<>();

        userToBeUpdate.setFirstName(updatedUser.getFirstName());
        userToBeUpdate.setLastName(updatedUser.getLastName());
        userToBeUpdate.setAge(updatedUser.getAge());
        userToBeUpdate.setEmail(updatedUser.getEmail());
        userToBeUpdate.setPassword(updatedUser.getPassword());
//        userToBeUpdate.setDiscord(updatedUser.getDiscord());
        userToBeUpdate.setRequest(updatedUser.isRequest());

        if (!updatedUser.getRoles().isEmpty()) {
            for (Role role : updatedUser.getRoles()) {
                roleSet.add((Role) sessionFactory.getCurrentSession()
                        .createQuery("select role from Role role where role.name=:name")
                        .setParameter("name", role.getName())
                        .uniqueResult());
            }
            userToBeUpdate.setRoles(roleSet);
        }

        sessionFactory.getCurrentSession().update(userToBeUpdate);
    }

    @Override
    public void deleteUser(String name) {
        sessionFactory.getCurrentSession().createQuery("delete User user where user.email=:name")
                .setParameter("name", name)
                .executeUpdate();
//        sessionFactory.getCurrentSession().delete(String.valueOf(id), User.class);
    }

    @Override
    public void deleteUserById(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete User user where user.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> readAllRoles() {
        return sessionFactory.getCurrentSession()
                .createQuery("select distinct role from Role role")
                .getResultList();
    }

    @Override
    public void addDiscordIdToUserByEmail(String email, String id) {
        User user = getUserByEmail(email);
        user.setDiscord(id);
        updateUser(user.getId(), user);
    }

    @Override
    public void sendRequestToAdmins(Long userId) {
        User userById = getUserById(userId);
        userById.setRequest(true);
        updateUser(userId, userById);

        List<String> adminsDiscordId = readUsers().stream()
                .filter(user -> user.getRoles().stream()
                        .anyMatch(role -> role.getName().equals("ROLE_ADMIN")))
                .map(User::getDiscord)
                .collect(Collectors.toList());

        discordService.sendRequest(adminsDiscordId, userId);
    }

    @Override
    public List<User> getUsersWithRequest() {
        return readUsers().stream().filter(User::isRequest).collect(Collectors.toList());
    }

    @Override
    public void approveAdminRole(Long id) {
        User userById = getUserById(id);
        Role adminRole = roleService.readAllRole().stream()
                .filter(role -> role.getName().equals("ROLE_ADMIN"))
                .findAny()
                .orElse(null);

        userById.getRoles().add(adminRole);
        userById.setRequest(false);
        updateUser(id, userById);
    }
}

