package leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestEquals {
	
	public static void main(String[] args) {
        String str1 = new String("张三");
        String str2 = new String("张三");
        Set<String> strSet = new HashSet<>();
        strSet.add(str1);
        strSet.add(str2);
//        System.out.println("strSet.size()：" + strSet.size());
        
        Person person1 = new Person("张三");
        Person person2 = new Person("张三");
        Set<Person> perSet = new HashSet<>();
        perSet.add(person1);
        perSet.add(person2);
//        System.out.println("perSet.size()：" + perSet.size());
        
        
        
        //引入List辅助测试
        List<Person> perList = new ArrayList<>();
        //把person1放入perList中,但是并没有放Person2
        perList.add(person1);
        //引入set辅助测试
        Set<Person> pSet = new HashSet<Person>();
        //把person1放入List中,但是并没有放Person2
        pSet.add(person1);
        System.out.println("person1.equals(person2) : " + person1.equals(person2));
        //判断perList里面是否包含person2
        System.out.println("perList.contains(person2) : " + perList.contains(person2));
        //判断pSet里面是否包含person2
        System.out.println("pSet.contains(person2) : " + pSet.contains(person2));
        
    }
}
