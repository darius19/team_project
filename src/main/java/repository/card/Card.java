package repository.card;

import lombok.*;
import repository.account.Account;
import repository.user.User;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data

public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID cardId;

    @NonNull
    private String completeName;

    @NonNull
    private String cardNumber;

    @NonNull
    private String expirationDate;

    @NonNull
    private String cvv;

    @ManyToOne
    @JoinColumn(name = "accountId" , nullable = false)
    private Account account;
}
