import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        System.out.println(item.viewInfo());
    }
}