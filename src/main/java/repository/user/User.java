package repository.user;

import lombok.*;
import repository.account.Account;
import java.time.LocalDate;
import repository.card.Card;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @NonNull
    @Column(name = "firstName")
    private String firstName;

    @NonNull
    @Column(name = "lastName")
    private String lastName;

    @NonNull
    private String identificationNumber;

    @NonNull
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;


}
