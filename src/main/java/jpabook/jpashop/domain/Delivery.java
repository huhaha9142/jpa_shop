package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)    //  연관관계 거울
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //  순서에 의해 밀리지 않게 ordinary 대신 string을 사용
    private DeliveryStatus status;  //  READY, COMPLETE
}
