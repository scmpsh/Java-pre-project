package web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.app.dao.UserDao;
import web.app.model.Role;
import web.app.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public List<User> readUsers() {
        return userDao.readUsers();
    }

    @Override
    public void updateUser(Long id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    public void deleteUser(String name) {
        userDao.deleteUser(name);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public List<Role> readAllRoles() {
        return userDao.readAllRoles();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getUserByEmail(username);
    }

//    @Override
//    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
//        String[] args = event.getMessage().getContentRaw().split(" ");
//        String username = Objects.requireNonNull(event.getMember()).getUser().getName();
//        String userId = event.getMember().getUser().getId();
//
//        if (args[0].equalsIgnoreCase("!login")) {
//            if (!event.getMember().getUser().isBot()) {
//                event.getMessage().reply("Привет, " + username +
//                        ", пожалуйста напиши email, который ты указал на сайте через команду " +
//                        "!email \"твой email без кавычек\"").queue();
//            }
//        }
//        if (args[0].equalsIgnoreCase("!email") && !args[1].isEmpty()) {
//            if (!event.getMember().getUser().isBot()) {
//                userDao.getUserByEmail(args[1]).setDiscord(userId);
//                event.getMessage().reply("Ваш ID добавлен в базу").queue();
//            }
//        }
//    }
}
