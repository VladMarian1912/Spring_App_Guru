package guru.springframework.domain;



import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
public class Product extends AbstractDomainClass {

    private String description;
    private BigDecimal price;
    private String imageUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<CartDetail> cartDetailList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<OrderDetail> orderDetailList;

    public void addCartDetail(CartDetail cartDetail) {
        cartDetailList.add(cartDetail);
    }

    public void deleteCartDetail(CartDetail cartDetail) {
        cartDetailList.remove(cartDetail);
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailList.add(orderDetail);
    }

    public void deleteOrderDetail(OrderDetail orderDetail) {
        orderDetailList.remove(orderDetail);
    }

}
