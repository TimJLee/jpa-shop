package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Getter @Setter
@Entity
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order") // read-only - 양방향 관계에서 연관관계의 주인은 반대쪽 테이블
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id") // 연관관계의 주인.
    private Delivery delivery;

    // 주문시간
    private LocalDateTime orderDate;

    // 주문상태 [ORDER, CANCEL]
    @Enumerated(EnumType.STRING) // 중간에 값 삽입되면 순서가 밀릴 수 있어서 String 으로 해야 함
    private OrderStatus status;


}
