import java.time.LocalDate;

public class BoardItem {

    //  FIELDS
    public String title;
    public LocalDate dueDate;
    public Status status;


    //  CONSTRUCTOR
    public BoardItem(String title, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = Status.Open;
    }

    //  GETTERS AND SETTERS
    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            int titleLength = title.length();
            if (titleLength >= 5 && titleLength <= 30) {
                this.title = title;
                return;
            }
        }
        System.out.println("Title length should be between 5-30.");
    }

    public void setDueDate(LocalDate dueDate) {
        if (dueDate != null && !dueDate.isBefore(LocalDate.now())) {
            this.dueDate = dueDate;
        } else {
            System.out.println("Due date cannot be in the past!");
        }
    }


    //  ENUM STATUS
    enum Status {
        Open, ToDo, InProgress, Done, Verified;

        public Status next() {
            int nextIndex = ordinal() + 1;
            if (nextIndex >= Status.values().length) {
                return null;
            }
            return Status.values()[nextIndex];
        }

        public Status previous() {
            int prevIndex = ordinal() - 1;
            if (prevIndex < 0) {
                return null;
            }
            return Status.values()[prevIndex];
        }
    }

    //  METHODS
    public void revertStatus() {
        Status prevStatus = status.previous();
        if (prevStatus != null) {
            status = prevStatus;
        }
    }

    public void advanceStatus() {
        Status nextStatus = status.next();
        if (nextStatus != null) {
            status = nextStatus;
        }
    }
    public String viewInfo() {
        return String.format("'%s', [%s | %s]", title, status, dueDate);
    }

}
 