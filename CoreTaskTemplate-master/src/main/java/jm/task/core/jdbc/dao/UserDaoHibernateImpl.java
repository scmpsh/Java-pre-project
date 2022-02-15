package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.security.auth.login.Configuration;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    Configuration configuration;

    public UserDaoHibernateImpl() {
//        this.configuration = Util.getConfiguration();
    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
