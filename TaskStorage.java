import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// по сути излишнее хранилище задач. Вы просили так не делать и все таки у меня получалось слишком мало примеров обощений,завел эту компоненту

public class TaskStorage<T extends Task> {
    private T[] ArrObg;

    public TaskStorage(T... obj) {
        this.ArrObg = obj;
    }

    public T[] getObg() {
        return ArrObg;
    }

    public void setObg(T[] ArrObg) {
        this.ArrObg = ArrObg;
    }

    public void SaveAllCSV() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("test.csv");
            StringBuilder sb = new StringBuilder();
            sb.append("ID");
            sb.append(',');
            sb.append("Text");
            sb.append(',');
            sb.append("Who");
            sb.append(',');
            sb.append("Priority");
            sb.append(',');
            sb.append("Time bulding");
            sb.append('\n');
            writer.write(sb.toString());
            for (T t : this.ArrObg) {
                t.SaveXLS(writer, "test.csv");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public T[] loadStorage(String Path) { // в отличие от записи читается сразу весь список задач. Чтение одиночной
        // задачи посчитал излишне, по хорошему можно считать только через UUID

        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("test.csv"))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ArrObg;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        boolean find = false;
        int tmp = values.get(0).indexOf("ID");
        for (T t : ArrObg) {

            if (values.get(0).indexOf(t.getID().toString()) == 0) { // Сравнить ID
                System.out.println("ID eqv");
                find = true;
                break;
            }
        }
        if (find == false && tmp == -1) {
            System.out.println("Новая задача"); /// так,естественно,неккоректно. по хорошему нужно сверять человека и
                                                /// только если его нет то создовать нового. а приоритет вообще
                                                /// проверять на соответсве enum и после жтого выставлять. не делал
                                                /// чтобы не перегружать метод
            Person Incognito = new Person(values.get(2));
            Priority incognitoPriority = new Priority(Variant.Hight);

            Task newTask = new Task(values.get(1), Incognito, incognitoPriority);

        }
        return values;
    }

    public void getAppendObgSorted() {

        var stepsCount = this.ArrObg.length - 1;
        boolean swapped;
        do {
            swapped = false;
            for (var i = 0; i < stepsCount; i++) {
                if (ArrObg[i].priority.getPriorityInteger() > ArrObg[i + 1].priority.getPriorityInteger()) {
                    var temp = ArrObg[i];
                    ArrObg[i] = ArrObg[i + 1];
                    ArrObg[i + 1] = temp;
                    swapped = true;
                }
            }
            stepsCount--;
        } while (swapped);
        for (T t : ArrObg) {
            t.printTaskToConsole();
        }

    }
}
