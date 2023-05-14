import java.time.LocalDate;

public class Main {d
    public static void main(String[] args) {
        BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        System.out.println(item.title);
        System.out.println(item.dueDate);
        System.out.println(item.status);
        }
    }
