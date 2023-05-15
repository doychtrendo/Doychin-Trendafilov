import java.time.LocalDate;

public class BoardItem {

    public String title;
    LocalDate dueDate;
    public Status status;

    public BoardItem (String title, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = Status.Open;
    }

    public void setTitle(String title) {
        if (title == null || title.length() <5 || title.length() > 30) {
            throw new IllegalArgumentException("Title length should be between 5-30!");
        }
        this.title = title;
    }


    public void setDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Due date cannot be in the past!");
        }
        this.dueDate = dueDate;
    }

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
}

