import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final List<BoardItem> items = new ArrayList<>();

    //CONSTRUCTOR
    private Board() {}

    //METHOD
    public static void addItem(BoardItem item) {
        items.add(item);
    }

    //METHOD
    public static List<BoardItem> getItems() {
        return items;
    }
}
