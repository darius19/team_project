package ui;

import repository.user.User;
import service.UserService;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    public UserInterface(EntityManager entityManager) {
        this.userService = new UserService(entityManager);
    }
    UserService userService;
    public void startApplicationInterface(){

        //create Scanner
        //input user
    }
}
