package com.ganga.relationships;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ganga.relationships.bientity.Customer1;
import com.ganga.relationships.bientity.Orders1;
import com.ganga.relationships.entity.Customer;
import com.ganga.relationships.entity.Orders;
import com.ganga.relationships.repo.CustomerBiRepository;
import com.ganga.relationships.repo.CustomerProfileBiRepository;
import com.ganga.relationships.repo.CustomerProfileUniRepository;
import com.ganga.relationships.repo.CustomerUniRepository;
import com.ganga.relationships.repo.OrdersBiRepository;
import com.ganga.relationships.repo.OrdersUniRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class RelationshipsApplication {
	private final CustomerBiRepository customerBiRepository;
	private final CustomerProfileBiRepository customerProfileBiRepository;
	private final OrdersBiRepository ordersBiRepository;
	private final OrdersUniRepository ordersUniRepository;
	private final CustomerProfileUniRepository customerProfileUniRepository;
	private final CustomerUniRepository customerUniRepository;

	public static void main(String[] args) {
		// SpringApplication.run(RelationshipsApplication.class, args);
		SpringApplication app = new SpringApplication(RelationshipsApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}

	private void addCustomerOrders() {
		Customer c = new Customer();
		c.setName("Pavan");
		c.setAge(20);

		Orders o1 = new Orders();
		o1.setName("Order 1");
		o1.setCost(100000);
		Orders o2 = new Orders();
		o2.setName("Order 2");
		o2.setCost(200000);
		Orders o3 = new Orders();
		o3.setName("Order 3");
		o3.setCost(300000);
		Orders o4 = new Orders();
		o4.setName("Order 4");
		o4.setCost(400000);
		Orders o5 = new Orders();
		o5.setName("Order 5");
		o5.setCost(500000);

		c.addOrder(o1);
		c.addOrder(o2);
		c.addOrder(o3);
		c.addOrder(o4);
		c.addOrder(o5);

		System.out.println(customerUniRepository.save(c));
	}

	private void addCustomerOrdersAtOnce() {
		Customer c = new Customer();
		c.setName("Pavan");
		c.setAge(20);

		List<Orders> orders = new ArrayList<>(List.of(
				new Orders(null, "Order 21", 10000),
				new Orders(null, "Order 22", 20000),
				new Orders(null, "Order 23", 30000),
				new Orders(null, "Order 24", 40000),
				new Orders(null, "Order 25", 50000)));

		c.setOrders(orders);
		System.out.println(customerUniRepository.save(c));
	}

	private void perfectCustomerOrderUpdatesAtOnce() {
		// preferred approach
		Customer c = customerUniRepository.findById(6l).orElse(null);
		List<Orders> existingOrders = ordersUniRepository.findByCustomer(6l);

		System.out.println(existingOrders);
		c.setName("pavan");
		c.setAge(22);

		Orders o1 = new Orders(6l, "Order 21", 10002);
		Orders o2 = new Orders(7l, "Order 22", 20002);
		Orders o3 = new Orders(8l, "Order 23", 30002);
		Orders o4 = new Orders(9l, "Order 24", 40002);
		Orders o5 = new Orders(10l, "Order 25", 50002);

		List<Orders> updatedOrders = new ArrayList<>(List.of(o1, o2, o3, o4));

		// Create a map of existing orders for easy lookup by order ID
		Map<Long, Orders> existingOrdersMap = existingOrders.stream()
				.collect(Collectors.toMap(Orders::getId, Function.identity()));

		// Update the orders that exist in the database and preserve the 5th order
		for (Orders updatedOrder : updatedOrders) {
			Orders existingOrder = existingOrdersMap.get(updatedOrder.getId());
			if (existingOrder != null) {
				existingOrder.setName(updatedOrder.getName());
				existingOrder.setCost(updatedOrder.getCost());
			}
		}

		for (Orders existingOrder : existingOrders) {
			if (!updatedOrders.contains(existingOrder)) {
				updatedOrders.add(existingOrder);
			}
		}
		c.setOrders(updatedOrders);

		System.out.println(
				customerUniRepository.save(c).getOrders());
	}

	private void updateCustomerOrdersAtOnce() {
		// Not a Recommended approach since the orders can be replaced
		Customer c = customerUniRepository.findById(6l).orElse(null);
		Customer ec = new Customer(6l, "pavans", 30, null);

		List<Orders> orders = ordersUniRepository.findByCustomer(6l);
		System.out.println(c.getId() + " " + c.getName());
		System.out.println(orders);

		Orders o1 = new Orders(6l, "Order 21", 10000);
		Orders o2 = new Orders(7l, "Order 22", 20000);
		Orders o3 = new Orders(8l, "Order 23", 30000);
		Orders o4 = new Orders(9l, "Order 24", 40000);
		Orders o5 = new Orders(10l, "Order 25", 50000);

		ec.setOrders(new ArrayList<>(List.of(o1, o2, o3, o4, o5)));

		System.out.println(customerUniRepository.save(ec));
	}

	// Bi-Directional Relationships
	private void addCustomerBiOrders() {
		Customer1 c = new Customer1();
		c.setName("Pavan");
		c.setAge(20);

		Orders1 o1 = new Orders1();
		o1.setName("Order 1");
		o1.setCost(100000);
		Orders1 o2 = new Orders1();
		o2.setName("Order 2");
		o2.setCost(200000);
		Orders1 o3 = new Orders1();
		o3.setName("Order 3");
		o3.setCost(300000);
		Orders1 o4 = new Orders1();
		o4.setName("Order 4");
		o4.setCost(400000);
		Orders1 o5 = new Orders1();
		o5.setName("Order 5");
		o5.setCost(500000);

		c.addOrder(o1);
		c.addOrder(o2);
		c.addOrder(o3);
		c.addOrder(o4);
		c.addOrder(o5);

		System.out.println(customerBiRepository.save(c));
	}

	private void addCustomerBiOrdersAtOnce() {
		Customer1 c = new Customer1();
		c.setName("Pavan");
		c.setAge(20);

		List<Orders1> orders = new ArrayList<>(List.of(
				new Orders1(null, "Order 21", 10000, c),
				new Orders1(null, "Order 22", 20000, c),
				new Orders1(null, "Order 23", 30000, c),
				new Orders1(null, "Order 24", 40000, c),
				new Orders1(null, "Order 25", 50000, c)));

		c.setOrders(orders);
		System.out.println(customerBiRepository.save(c));
	}

	private void perfectCustomerBiOrderUpdatesAtOnce() {
		// preferred approach
		Customer1 c = customerBiRepository.findById(6l).orElse(null);
		List<Orders1> existingOrders = ordersBiRepository.findByCustomer(c);

		System.out.println(existingOrders);
		c.setName("pavan");
		c.setAge(22);

		Orders1 o1 = new Orders1(6l, "Order 21", 10002, c);
		Orders1 o2 = new Orders1(7l, "Order 22", 20002, c);
		Orders1 o3 = new Orders1(8l, "Order 23", 30002, c);
		Orders1 o4 = new Orders1(9l, "Order 24", 40002, c);
		Orders1 o5 = new Orders1(10l, "Order 25", 50002, c);

		List<Orders1> updatedOrders = new ArrayList<>(List.of(o1, o2, o3, o4));

		// Create a map of existing orders for easy lookup by order ID
		Map<Long, Orders1> existingOrdersMap = existingOrders.stream()
				.collect(Collectors.toMap(Orders1::getId, Function.identity()));

		// Update the orders that exist in the database and preserve the 5th order
		for (Orders1 updatedOrder : updatedOrders) {
			Orders1 existingOrder = existingOrdersMap.get(updatedOrder.getId());
			if (existingOrder != null) {
				existingOrder.setName(updatedOrder.getName());
				existingOrder.setCost(updatedOrder.getCost());
			}
		}

		for (Orders1 existingOrder : existingOrders) {
			if (!updatedOrders.contains(existingOrder)) {
				updatedOrders.add(existingOrder);
			}
		}
		c.setOrders(updatedOrders);

		System.out.println(
				customerBiRepository.save(c).getOrders());
	}


	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			// perfectCustomerBiOrderUpdatesAtOnce();
		};
	}

}
