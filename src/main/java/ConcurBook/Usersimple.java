package ConcurBook;

public class Usersimple {
    String name;
    int age;

    public Usersimple(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Usersimple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
