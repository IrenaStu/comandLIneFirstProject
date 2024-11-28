import java.time.LocalDateTime;


public class LimitedTimeTask extends Task{
//    Initialise LimitedTimeTask field
    private LocalDateTime deadline;

// LimitedTimeTask class constructor
    public LimitedTimeTask(String taskName, String taskDescription, String userName,LocalDateTime deadline  ) {
//        Parent class constructor
        super(taskName, taskDescription, userName);
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return super.toString().substring(0,super.toString().length()-2)+
                " deadline=" + deadline +
                '}';
    }
}
