package com.example.inflearnjpa1.service;

import com.example.inflearnjpa1.entity.Address;
import com.example.inflearnjpa1.entity.Member;
import com.example.inflearnjpa1.entity.Order;
import com.example.inflearnjpa1.entity.OrderStatus;
import com.example.inflearnjpa1.entity.item.Book;
import com.example.inflearnjpa1.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품_주문() throws Exception {
        Member member = new Member();
        member.setName("회원 1");
        member.setAddress(new Address("서울", "한강로", "123"));
        em.persist(member);

        Book book = new Book();
        book.setName("JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        Order getOrder = orderRepository.findOne(orderId);

        Assertions.assertEquals(OrderStatus.ORDER, getOrder.getStatus());
    }

    @Test
    public void 상품즈믄제고수량초과() throws Exception {
        Member member = new Member();
        member.setName("회원 1");
        member.setAddress(new Address("서울", "한강로", "123"));
        em.persist(member);

        Book book = new Book();
        book.setName("JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        int orderCount = 11;
        orderService.order(member.getId(), book.getId(), orderCount);

        fail("재고 수량 부족 예외가 발생");


    }

    @Test
    public void 주문_취소() throws Exception {
        Member member = new Member();
        member.setName("회원 1");
        member.setAddress(new Address("서울", "한강로", "123"));
        em.persist(member);

        Book book = new Book();
        book.setName("JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        orderService.cancelOrder(orderId);

        Order getOrder = orderRepository.findOne(orderId);

        Assertions.assertEquals(OrderStatus.CANCEL, getOrder.getStatus());
        Assertions.assertEquals(10, book.getStockQuantity());
    }
}