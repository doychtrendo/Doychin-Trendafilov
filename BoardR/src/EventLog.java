import java.time.LocalDate;

public class EventLog {


    //FIELDS
    private final String description;
    private final LocalDate timestamp;


    //CONSTRUCTOR
    public EventLog (String description) {
        this.description = description;
        this.timestamp = LocalDate.now();
    }

    public EventLog () {
        this.description = getDescription();

        this.timestamp = LocalDate.now();
        if (timestamp.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Due date cannot be in the past!");
        }
    }

    //GETTERS
    public String getDescription() {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be empty!");
        }
        return description;
    }

    //METHODS
    public String viewInfo() {
        return String.format("[%s] %s", timestamp, description);
    }

}