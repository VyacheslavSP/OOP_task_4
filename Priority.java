/* в рамках задачи приоритетность как отдельный класс выглядит странно, однако спекциально оставлено.
 из соображений- этой кончтрукцией можно полховаться не только для постановки конкретной задачи а такая запись гарантирует 
 что у нас в БД будет поле с заранее определенными значениями
 
*/import java.util.HashMap;

enum Variant {
    Hight, Medium, Low
}

public class Priority {
    public Priority(Variant priority) {
        
        HashMap <Variant,Integer> priorityMap = new HashMap<>();
        priorityMap.put(Variant.Hight, 0);
        priorityMap.put(Variant.Medium, 1);
        priorityMap.put(Variant.Low, 2);
        this.priority = priority;
        this.priorityMap=priorityMap;
        
    }

    private Variant priority;
    private HashMap <Variant,Integer> priorityMap;

    public Variant getPriority() {
        return priority;
    }

    public void setPriority(Variant priority) {
        this.priority = priority;
    }
    public Integer getPriorityInteger() {
        Integer temp=priorityMap.get(this.priority);
        return temp;
    }
}
    