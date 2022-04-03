package com.example.inflearnjpa1.repository;

import com.example.inflearnjpa1.entity.Order;
import com.example.inflearnjpa1.entity.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

//    public List<Order> findAll(OrderSearch orderSearch) {
//        String sql = "SELECT o FROM Order o JOIN o.member m";
//
//
//        return em.createQuery(sql, Order.class)
//                .getResultList();
//    }
}
