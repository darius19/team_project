package repository.user;

import config.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Scanner;

public class UserRepository {

    // Create Entity Manager for all methods

    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Methods


    public void saveUser(User user) {


        EntityTransaction entityTransaction = null;

        try {

            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();
        } catch (Exception exception) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            System.out.println("SaveUser failed!");
        }


    }

}
