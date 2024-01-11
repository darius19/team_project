package service;

import org.hibernate.SessionFactory;
import repository.user.User;
import repository.user.UserRepository;

import javax.persistence.EntityManager;

public class UserService {

    public UserService(EntityManager entityManager) {
        this.userRepository = new UserRepository(entityManager);
    }

    UserRepository userRepository;

    public void createUser(User user){


        userRepository.saveUser(user);

        //userRepository.saveUser(user);
    }


}
