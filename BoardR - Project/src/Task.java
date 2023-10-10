import java.time.LocalDate;

public class Task extends BoardItem {

    public static final int MIN_ASSIGNEE_LENGTH = 5;
    public static final int MAX_ASSIGNEE_LENGTH = 30;

    private String assignee;

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate, Status.ToDo);
        setAssignee(assignee);
    }

    public String getAssignee() {
        return assignee;
    }

    protected void setAssignee(String assignee) {
        if (assignee == null || assignee.length() < MIN_ASSIGNEE_LENGTH || assignee.length() > MAX_ASSIGNEE_LENGTH) {
            throw new IllegalArgumentException("Title length should be between 5-30!");
        }
        if (this.assignee != null) {
            logEvent("Assignee changed from " + this.assignee + " to " + assignee);
        }
        this.assignee = assignee;
    }
}
