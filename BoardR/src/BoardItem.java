import java.time.LocalDate;
import java.util.ArrayList;

public class BoardItem {
    //FIELDS
    private String title;
    private LocalDate dueDate;
    private Status status;
    private final ArrayList<EventLog> eventHistory = new ArrayList<>();

    //CONSTRUCTOR
    public BoardItem(String title, LocalDate dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        this.status = Status.Open;
        logEvent("Item created: '" + this.title + "', [" + this.status + " | " + this.dueDate + "]");
    }


    //GETTERS

    public LocalDate getDueDate() {
        return dueDate;
    }


    //SETTERS
    public void setTitle(String title) {
        if (title == null || title.length() < 5 || title.length() > 30) {
            throw new IllegalArgumentException("Title length should be between 5-30!");
        }
        if (this.title != null) {
            logEvent("Title changed from " + this.title + " to " + title);
        }
        this.title = title;
    }

    public void setDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Due date cannot be in the past!");
        }
        if (this.dueDate != null) {
            logEvent("DueDate changed from " + this.dueDate + " to " + dueDate);
        }
        this.dueDate = dueDate;
    }

    private void logEvent(String message) {
        EventLog eventLog = new EventLog("[" + LocalDate.now() + "] " + message);
        eventHistory.add(eventLog);
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
