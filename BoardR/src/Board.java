
import java.util.ArrayList;

public class Board {
    private ArrayList<BoardItem> items;

    public Board() {
        int totalItems = 0;
        items = new ArrayList<>();
    }

    public ArrayList<BoardItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<BoardItem> items) {
        this.items = items;
    }

    public void addItem(BoardItem item) {
        if (!items.contains(item)) {
            items.add(item);
        }
        throw new IllegalArgumentException("Item already in the list");
    }

    public int totalItems() {
        return items.size();
    }
}


//make the list private
//create method void аddItem(BoardItem item) adds to the list of items inside the Board
//in the method do a check if they already exist using contains()
//how many items we have in the board - add int totalItems - returns the count of items inside the Board.
//addItem() method should throw an IllegalArgumentException when a duplicate is added.