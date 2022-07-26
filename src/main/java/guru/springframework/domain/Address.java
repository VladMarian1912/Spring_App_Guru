package guru.springframework.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@ToString()
public class Address {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
}
