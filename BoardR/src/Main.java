import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BoardItem item3 = new BoardItem("Implement login/logout", LocalDate.now().plusDays(3));
        BoardItem item4 = new BoardItem("Secure admin endpoints", LocalDate.now().plusDays(5));

        Board board = new Board();

        board.addItem(item3); // add item1
        board.addItem(item4); // add item2

        System.out.println(board.totalItems()); // count: 2
    }
}