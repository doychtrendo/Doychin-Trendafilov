package com.company.oop;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        Order order1 = new Order(
                "John",
                Currency.BGN,
                LocalDate.of(2022, Month.JANUARY, 15));

        order1.addItem(new Product("Keyboard", 56));
        order1.addItem(new Product("Monitor", 125));

        Order order2 = new Order(
                "Peter",
                Currency.USD,
                LocalDate.of(2021, Month.AUGUST, 22));

        order2.addItem(new Product("Sweater", 25));
        order2.addItem(new Product("Jeans", 30));

        InternationalOrder order3 = new InternationalOrder(
                "Roger",
                Currency.USD,
                LocalDate.of(2021, Month.MAY, 28),
                "TopHamaliEOOD",
                20);

        order3.addItem(new Product("Backpack", 16));
        order3.addItem(new Product("Speakers", 90));

        Order[] orders = new Order[]{order1, order2};
        for (var order : orders) {
            System.out.println(order.getGeneralInfo());
            System.out.println(order.getOrderItemsInfo());
        }

        InternationalOrder[] internationalOrders = new InternationalOrder[]{order3};
        for (InternationalOrder internationalOrder : internationalOrders) {
            System.out.println(internationalOrder.getInternationalOrderGeneralInfo());
            System.out.println(internationalOrder.getOrderItemsInfo());
        }
    }

}
