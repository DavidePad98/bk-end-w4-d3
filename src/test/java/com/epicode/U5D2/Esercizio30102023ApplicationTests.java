package com.epicode.U5D2;

import com.epicode.U5D2.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class Esercizio30102023ApplicationTests {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D2Application.class);


	@Test
	public void testSum() {
		int result = MathTest.sum(5,5);
		assertEquals(10, result);
		System.out.println("test somma" + " " + result);
	}

	@ParameterizedTest
	@CsvSource({"1, 2, 3", "4, 5, 9", "10, 20, 30"})
	public void testAddition(int a, int b, int expected) {
		int result = MathTest.sum(a, b);
		assertEquals(expected, result);
	}

	@Value("${seat.price}")
	private double seatPrice;
	@Test
	public void testSeatPrice() {
		double expectedPrice = 2.00;
		assertEquals(expectedPrice, seatPrice);
	}

	@Test
	public void testPrintMenu(){
		try{
			Menu menu = (Menu) ctx.getBean("menu");
			menu.printMenu();
		} finally {
			ctx.close();
		}
	}

	@Test
	public void orderCreation(){
		try{
			Table table = (Table) ctx.getBean("Tavolo1");
			Order order = new Order(4, table);

			Pizza pizza1 = (Pizza) ctx.getBean("pizza_margherita", Pizza.class);
			Pizza pizza2 = (Pizza) ctx.getBean("hawaiian_pizza", Pizza.class);
			Pizza pizza3 = (Pizza) ctx.getBean("salami_pizza_xl", Pizza.class);
			Drink lemonade = (Drink) ctx.getBean("lemonade", Drink.class);
			Drink wine = (Drink) ctx.getBean("wine", Drink.class);

			order.addItem(pizza1);
			order.addItem(pizza2);
			order.addItem(pizza3);
			order.addItem(lemonade);
			order.addItem(lemonade);
			order.addItem(wine);

			order.print();
		} finally {
			ctx.close();
		}
	}

	@Value("${test.string}")
	private String test;
	@Test
	public void stringTest(){
		String s = "ciao";
		assertEquals(s, test);
		System.out.println("application.properties value: " + test);
		System.out.println("strind test value: " + s);
	}

}
