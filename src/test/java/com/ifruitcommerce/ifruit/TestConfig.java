package com.ifruitcommerce.ifruit;

import com.ifruitcommerce.ifruit.entities.*;
import com.ifruitcommerce.ifruit.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Criando usuários
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));

        // Criando categorias
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2));

        // Criando produtos
        Product p1 = new Product(null, "TV", "Smart TV", 2000.0, "http://img.com/img1.png");
        Product p2 = new Product(null, "Domain Driven Design", "DDD Book", 120.0, "http://img.com/img2.png");
        productRepository.saveAll(Arrays.asList(p1, p2));

        // Criando pedidos
        Order o1 = new Order(null, new Date(), OrderStatus.PAID);
        orderRepository.saveAll(Arrays.asList(o1));

        // Criando itens de pedido
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p2, 1, p2.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2));

        // Criando pagamento
        Payment pay1 = new Payment(null, new Date(), o1);
        paymentRepository.save(pay1);
    }
}
