package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    /* public static void main(String[] args) {
         UserService userService = new UserServiceImpl();

         userService.createUsersTable();

         userService.saveUser("Nana", "Moon", (byte) 20);
         userService.saveUser("Nik", "Next", (byte) 25);
         userService.saveUser("Nika", "Moo", (byte) 31);
         userService.saveUser("An", "Xl", (byte) 38);


         userService.removeUserById(1);//?
         userService.getAllUsers();
         userService.cleanUsersTable();
        userService.dropUsersTable();
    */// }
    public static void main(String[] args) {
        UserService userDao = new UserServiceImpl();

        userDao.createUsersTable();

        userDao.saveUser("Nana", "Moon", (byte) 20);
        userDao.saveUser("Nik", "Next", (byte) 25);
        userDao.saveUser("Nika", "Moo", (byte) 31);
        userDao.saveUser("An", "Xl", (byte) 38);


        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
