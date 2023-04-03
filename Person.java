public class Person {
    
    @Override
    public String toString() {
        return "Person [Name=" + Name + "]";
    }

    public String Name;

    public Person(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
