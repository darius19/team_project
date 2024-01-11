package repository.account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AccountRepository {

    private final EntityManager entityManager;

    public AccountRepository(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public void saveAccount(Account account){

        EntityTransaction entityTransaction = null;

        try {

            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(account);
            entityTransaction.commit();
        } catch (Exception exception) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            System.out.println("SaveAccount failed!");
        }
    }
}
