import java.time.LocalDateTime;

public class RepeatableTask extends LimitedTimeTask {
    //    Initialise RepeatableTask field
    private int repeatNumber;
// RepeatableTask constructor
    public RepeatableTask(String taskName, String taskDescription, LocalDateTime localDateTime, String userName, int repeatNumber) {
        super(taskName, taskDescription, userName,localDateTime);
        this.repeatNumber = repeatNumber;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public int getRepeatNumber() {
        return repeatNumber;
    }

    public void setRepeatNumber(int repeatNumber) {
        this.repeatNumber = repeatNumber;
    }

    @Override
    public String toString() {
        return super.toString().substring(0,super.toString().length()-2)+
                " repeatNumber=" + repeatNumber +
                '}';
    }
}
