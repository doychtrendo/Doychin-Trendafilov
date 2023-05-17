import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BoardItem {


    //FIELDS
    private String title;
    LocalDate dueDate;
    private Status status;
    public List<EventLog> eventHistory;


    //CONSTRUCTOR
    public BoardItem (String title, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = Status.Open;
        this.eventHistory = new ArrayList<>();
    }


    //GETTERS - always public
    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Status getStatus() {
        return status;
    }


    //SETTERS - always private
    public void setTitle(String title) {
        if (title == null || title.length() <5 || title.length() > 30) {
            throw new IllegalArgumentException("Title length should be between 5-30!");
        }
        this.eventHistory.add(new EventLog("Title changed from " + this.title + " to " + title));
        this.title = title;
    }


    public void setDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Due date cannot be in the past!");
        }
        this.dueDate = dueDate;
    }


    //METHODS
    public void revertStatus() {
        Status previous = status.previous();
        if (previous != null) {
            status = previous;
        }
    }

    public void advanceStatus() {
        Status next = status.next();
        if (next != null) {
            status = next;
        }
    }

    public String viewInfo() {
        return String.format("'%s', [%s | %s]", title, status, dueDate);
    }

    public String displayHistory() {
        StringBuilder sb = new StringBuilder();
        for (EventLog event : eventHistory) {
            sb.append(event.viewInfo()).append("\n");
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}


