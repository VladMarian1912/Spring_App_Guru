package guru.springframework.domain;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class Product extends AbstractDomainClass {

    private String description;
    private BigDecimal price;
    private String imageUrl;
}
