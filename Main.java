public class Main {
    public static void main(String[] args) {
        Priority highPriority= new Priority(Variant.Hight);
        System.out.println(highPriority.getPriority());
        System.out.println(highPriority.getPriorityInteger());
        TaskText Task1=new TaskText("Калибровка");
        TaskText Task2=new TaskText("Аттестация");
        TaskText Task3=new TaskText("Рутиная поверка");
        System.out.println(Task3.getDateBuildTask());
        Person Pugachev=new Person("Пугачев В.С.");
        Person Ovcharenko=new Person("Овчаренко Г.О.");
        Person Petrunin=new Person("Петрунин М.С.");
    }
}