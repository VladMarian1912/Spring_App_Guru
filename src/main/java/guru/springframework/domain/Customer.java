package guru.springframework.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Customer extends AbstractDomainClass {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Embedded
    private Address billingAddress;

    @Embedded
    private Address shippingAddress;

//    initial, dar nu merge
//    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OneToOne(cascade = {CascadeType.ALL})
    private User user;
}
