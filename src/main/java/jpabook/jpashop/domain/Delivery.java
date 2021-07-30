package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")  // read-only - 양방향 관계에서 연관관계의 주인은 반대쪽 테이블
    private Order order;

    @Embedded
    private Address address;

    // READY, COMP
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
