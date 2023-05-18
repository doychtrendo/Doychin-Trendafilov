public class Product {

    //CONSTANTS
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 15;

    //FIELDS
    private String name;
    private double price;
    private Currency currency;

    //CONSTRUCTOR
    public Product(String name, double price, Currency currency) {
        setName(name);
        setPrice(price);
        setCurrency(currency);
    }

    //SECOND CONSTRUCTOR
    public Product(String name, double price){
        this(name, price, Currency.BGN);
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Product name must be between 2 and 15 characters");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Product price must be greater than 0");
        }
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    private void setCurrency(Currency currency) {
        this.currency = currency;
    }

    //METHOD
    public String getDisplayInfo() {
        return String.format("%s - %.2f %s", name, price, currency);
    }
}
