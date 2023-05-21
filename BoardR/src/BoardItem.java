import java.time.LocalDate;
import java.util.ArrayList;

public class BoardItem {

    //CONSTANTS
    private static final int MIN_TITLE_LENGTH = 5;
    private static final int MAX_TITLE_LENGTH = 30;

    //FIELDS
    private String title;
    private LocalDate dueDate;
    private Status status;
    private final ArrayList<EventLog> eventHistory = new ArrayList<>();

    //CONSTRUCTOR
    public BoardItem(String title, LocalDate dueDate, Status status) {
        setTitle(title);
        setDueDate(dueDate);
        this.status = status;
        logEvent("Item created: '" + this.title + "', [" + this.status + " | " + this.dueDate + "]");
    }

    void logEvent(String message) {
        EventLog eventLog = new EventLog(message);
        eventHistory.add(eventLog);
    }

    //GETTERS AND SETTERS
    public Status getStatus() {
        return status;
    }

    private void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<EventLog> getEventHistory() {
        return eventHistory;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    void setDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Due date cannot be in the past!");
        }
        if (this.dueDate != null) {
            logEvent("DueDate changed from " + this.dueDate + " to " + dueDate);
        }
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        if (title == null || title.length() < MIN_TITLE_LENGTH || title.length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException("Title length should be between 5-30!");
        }
        if (this.title != null) {
            logEvent("Title changed from " + this.title + " to " + title);
        }
        this.title = title;
    }


    //METHODS
    public void revertStatus() {
        Status previous = status.previous();
        if (previous != null) {
            status = previous;
            logEvent("Status changed from " + status.next() + " to " + status);
        } else {
            logEvent("Can't revert, already at " + status);
        }
    }

    public void advanceStatus() {
        Status next = status.next();
        if (next != null) {
            status = next;
            logEvent("Status changed from " + status.previous() + " to " + status);
        } else {
            logEvent("Can't advance, already at " + status);
        }
    }

    public String viewInfo() {
        return String.format("'%s', [%s | %s]", title, status, dueDate);
    }

    public String displayHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        for (EventLog event : eventHistory) {
            stringBuilder.append(event.viewInfo()).append("\n");
        }

        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }
}


