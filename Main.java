public class Main {
    public static void main(String[] args) {
        Priority highPriority = new Priority(Variant.Hight);
        System.out.println(highPriority.getPriority());
        System.out.println(highPriority.getPriorityInteger());
        Person Pugachev = new Person("Пугачев В.С.");
        Person Petrunin = new Person("Петрунин М.С.");
        Task task1 = new Task("Тестовое сообщениме", Petrunin, highPriority);
        Task task2 = new Task("Второе тестовое сообщениме", Pugachev, new Priority(Variant.Low));
        Task task3 = new Task("3 test", new Person("Овчаренко Г.О."), new Priority(Variant.Medium));
        Task task4 = new Task("4 test", Pugachev, highPriority);
        TaskStorage<Task> Storgage = new TaskStorage<>(task1, task2, task3, task4);
        Storgage.getAppendObgSorted();
        Storgage.SaveAllCSV();
        Storgage.loadStorage("test.csv");
    }
}