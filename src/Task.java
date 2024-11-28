import java.util.Objects;

public class Task {
//    initialising fields
    private String taskName;
    private String taskDescription;
    private String userName;


//    Task constructor
public Task(String taskName, String taskDescription, String userName) {
    this.taskName = taskName;
    this.taskDescription = taskDescription;
    this.userName = userName;
}

//    equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(taskName, task.taskName);
    }
//hashCode method for comparing objects
    @Override
    public int hashCode() {
        return Objects.hashCode(taskName);
    }

//    Getter method to reach privet fileds of class out of it

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getUserName() {
        return userName;
    }

//    Setter method for setting privet fields value out of constructor if needed

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


//   toString  method
    @Override
    public String toString() {
        return getClass().toString().substring(6) + "{" +
                "taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
