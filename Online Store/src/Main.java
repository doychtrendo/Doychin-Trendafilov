import java.time.LocalDate;

public class Main {
    public static void main(String... args) {

        Order order1 = new Order("John",  Currency.BGN, LocalDate.now());
        order1.getItems().add(new Product("Keyboard", 50));
        order1.getItems().add(new Product("Monitor", 100));

        Order order2 = new Order("Doychin", Currency.EUR, LocalDate.now());
        order2.getItems().add(new Product("Playstation 5", 500));
        order2.getItems().add(new Product("Oculus VR2", 300));


        Order[] orders = new Order[] {order1, order2};

        for (Order order:orders) {
            order.displayGeneralInfo();
            System.out.println(" ");
            order.displayOrderItems();
            System.out.printf("%n--------------------%n");
        }
    }
}