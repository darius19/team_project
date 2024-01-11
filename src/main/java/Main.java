import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.account.Account;
import repository.account.AccountRepository;
import repository.card.Card;
import repository.user.User;
import repository.user.UserRepository;
import ui.UserInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Card.class)
                .buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            EntityManager entityManager = sessionFactory.createEntityManager();

//            UserInterface userInterface = new UserInterface(entityManager);
//            userInterface.startApplicationInterface();


            User user1 = new User("Darius", "Apostol", "1223344556677", LocalDate.now());

            UserRepository userRepository = new UserRepository(entityManager);
            userRepository.saveUser(user1);


            Account account1 = new Account("EUR", "123456678899", 200.0,3);

            AccountRepository accountRepository = new AccountRepository(entityManager);
            accountRepository.saveAccount(account1);
            account1.setUser(user1);




        }

    }
}
