import lombok.*;

/**
 * Class to keep record of Contacts of Person
 */
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class Contact {

    private String type;
    private String value;

}