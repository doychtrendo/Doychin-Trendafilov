import java.time.LocalDate;

public class Issue extends BoardItem {

    private String description;

    public Issue(String title, String description, LocalDate dueDate) {
        super(title, dueDate, Status.Open);
        setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            this.description = "No description";
        } else {
            this.description = description;
        }
    }
}

