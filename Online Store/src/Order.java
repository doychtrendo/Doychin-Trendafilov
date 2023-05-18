import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    //CONSTANT - ALWAYS PRIVATE
    private static final int MIN_RECIPIENT_NAME_LENGTH = 3;
    private static final int MAX_RECIPIENT_NAME_LENGTH = 35;
    private static final int BGN_TO_EUR_CONVERSION_RATE = 2;

    //FIELDS
    private String recipient;
    private Currency currency;
    private LocalDate deliveryOn;
    private ArrayList<Product> items;

    //CONSTRUCTOR
    public Order (String recipient, Currency currency, LocalDate deliveryOn) {
        setRecipient(recipient);
        setCurrency(currency);
        setDeliveryOn(deliveryOn);
        items = new ArrayList<>();
    }

    //instead of setter we create a method for the items list
    public void addItem(Product item){
        if (getItems().contains(item)){  //check if item already exists in the order
            throw new IllegalArgumentException("This item is already in this order");
        }
        items.add(item); //if not add item to the items list
    }

    //instead of getter for the items
    public List<Product> getItems(){
        return new ArrayList<>(items); //return copy of the collection - create new array list of items - if we return the collection and not a list anyone can change the items in the collection
    }

    //GETTERS
    public String getRecipient(){
        return recipient;
    }
    public LocalDate getDeliveryOn(){
        return deliveryOn;
    }
    public Currency getCurrency(){
        return currency;
    }


    //SETTERS - ALWAYS PRIVATE
    private void setRecipient(String recipient){
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient cannot be empty");
        }
            if (recipient.length()< MIN_RECIPIENT_NAME_LENGTH || recipient.length()> MAX_RECIPIENT_NAME_LENGTH) {
                throw new IllegalArgumentException("Recipient name must be between 3 and 35 characters");
            }
        this.recipient = recipient;
        }

    private void setDeliveryOn(LocalDate deliveryOn){
        this.deliveryOn = deliveryOn;
    }
    private void setCurrency(Currency currency){
        this.currency = currency;
    }

    //METHODS
    public void displayOrderItems() { //izpisva vsichki artikuli v porachkata - pravim proverka ako nqma artikuli
        if (items.size() == 0) {
            System.out.println("No items");
        }
        StringBuilder builder = new StringBuilder("Items: "); // ako ima artikuli izvejdame v konzolata sus string builder - obikalq items s for each loop
        for(Product item:items) {
            builder.append(String.format(" %s", item.getDisplayInfo())); //dobavqme v string buildera
        }
        System.out.println(builder.toString()); //izejdame v konzolata sudarjanieto na buildera
    }

    public void displayGeneralInfo() { //izpisva informaciq za samata porachka
        System.out.printf("Order to: %s | Delivery on: %s | Total: %s", recipient , deliveryOn, calculateTotalPrice());
    }

    public  double calculateTotalPrice(){
        double total = 0;
        for (Product product:items) {
            total += product.getPrice();
        }
        if (currency == Currency.EUR){
            total = total * BGN_TO_EUR_CONVERSION_RATE;
        }
        return total;
    }
}
