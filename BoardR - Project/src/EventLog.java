import java.time.LocalDateTime;

public class EventLog {

    private final String description;
    private final LocalDateTime timestamp;


    public EventLog(String description) {
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public EventLog() {
        this.description = getDescription();
        this.timestamp = LocalDateTime.now();
        if (timestamp.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Due date cannot be in the past!");
        }
    }

    public String getDescription() {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be empty!");
        }
        return description;
    }

    public String viewInfo() {
        return String.format("[%d-%s-%d %d:%d:%d] %s",
                timestamp.getDayOfMonth(),
                timestamp.getMonth(),
                timestamp.getYear(),
                timestamp.getHour(),
                timestamp.getMinute(),
                timestamp.getSecond(),
                description);
    }

}