import lombok.*;
import java.util.List;
import java.time.LocalDate;

/**
 * Person class to keep record for people in the database
 */
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Address address;
    private List<Contact> contacts;
    private Gender gender;
    private boolean isActive;

}