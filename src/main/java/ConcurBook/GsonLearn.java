package ConcurBook;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonLearn {
    public static void main(String[] args) {
        Gson gson = new Gson();
        List<Integer> friends = new ArrayList<>();
        friends.add(1);
        friends.add(2);
        User user1 = new User("name", 12, friends);
        Usersimple u2 = new Usersimple("name2",12);
        System.out.println(gson.toJson(user1));
        String ss = gson.toJson(user1);
        String s = "{\"name\":\"name\",\"age\":12,\"friendsID\":[1,2]}";
        System.out.println(s);
        System.out.println(ss.equals(s));
        Type type = new TypeToken<User<Integer>>() {
        }.getType();

        System.out.println(gson.toJson(u2));
        System.out.println(gson.fromJson(gson.toJson(u2), Usersimple.class));
        String s1 = gson.toJson(user1);
        System.out.println(s1);
        System.out.println(gson.fromJson(ss, User.class));
//        System.out.println(gson.toJson(s, type));
    }
}
