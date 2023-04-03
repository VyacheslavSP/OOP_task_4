import java.util.Date;

/* данный класс используется как некая анонимная безадресная задача/запрос. Из соображений что сначала появляется запрос
а потом он распределяется по конкретному исполнителю. При этом одна и та же задача может быть поставлена разным людям,
в разное время и т.д. При этом этот класс хранит тело и время создания запроса. ПРИ ЭКСПОРТЕ И ИМПОРТЕ ПОЛЕ ДАТА НЕ 
ОБРАБАТЫВАЕТСЯ!!!!!*/
public abstract class TaskText {
    public String bodyTask;
    private Date dateBuildTask;

    public TaskText(String bodyTask) {
        this.bodyTask = bodyTask;
        this.dateBuildTask = new Date();
    }

    public String getBodyTask() {
        return bodyTask;
    }

    public void setBodyTask(String bodyTask) {
        this.bodyTask = bodyTask;
    }

    public Date getDateBuildTask() {
        return dateBuildTask;
    }

    public void setDateBuildTask(Date dateBuildTask) {
        this.dateBuildTask = new Date();
    }

}