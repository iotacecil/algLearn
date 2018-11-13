package ConcurBook;

import java.util.List;

public class User<T> {
    String name;
    int age;
    List<T> friendsID;

    public User(String name, int age, List<T> friendsID) {
        this.name = name;
        this.age = age;
        this.friendsID = friendsID;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friendsID=" + friendsID +
                '}';
    }
}
