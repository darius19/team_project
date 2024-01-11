package repository.account;

import lombok.*;
import repository.card.Card;
import repository.user.User;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID accountId;

    @NonNull
    private String currency;

    @NonNull
    private String iban;

    @NonNull
    private double balance;

    @NonNull
    private int numberOfCards;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "account")
    private List<Card> cards;


}
