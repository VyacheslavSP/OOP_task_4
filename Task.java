import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

public class Task extends TaskText implements Interface {

    private UUID ID;
    public Person person;
    public Priority priority;
    public String bodyTask;
    private Date BuildTask;

    public Task(String bodyTask, Person person, Priority priority) {
        super(bodyTask);
        this.bodyTask = bodyTask;
        ID = UUID.randomUUID();
        this.person = person;
        this.priority = priority;
        BuildTask = new Date();
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID iD) {
        ID = iD;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getBodyTask() {
        return bodyTask;
    }

    public void setBodyTask(String bodyTask) {
        this.bodyTask = bodyTask;
    }

    @Override
    public void SaveXLS(PrintWriter writer, String Path) {
               StringBuilder sb = new StringBuilder();
                   sb.append(this.ID);
            sb.append(',');
            sb.append(this.bodyTask.toString());
            sb.append(',');
            sb.append(this.person.getName());
            sb.append(',');
            sb.append(this.priority.getPriority());
            sb.append(',');
            sb.append(this.BuildTask);
            sb.append('\n');

            writer.write(sb.toString());
                   }
    

    @Override
    public void printTaskToConsole() {

        System.out.println("Это задача: ID=" + this.ID + " тескcт задачи " + this.bodyTask.toString() + " назначена "
                + this.person.getName() + " с приоритетом " + this.priority.getPriority() + " создана "
                + this.BuildTask);
    }

    public Date getBuildTask() {
        return BuildTask;
    }

}
