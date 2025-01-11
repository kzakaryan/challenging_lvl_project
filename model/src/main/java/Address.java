import lombok.*;

/**
 * Class to keep track of geographical location of people
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

}