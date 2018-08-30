package javaquickTest.lambdaStream;

import java.util.function.*;

class Dog{
    public Dog(int food) {
        this.food = food;
    }

    public Dog() {
    }

    //消费者：输入Dog，输出void
    public static void Bark(Dog dog){

        System.out.println("bark");
    }
    private int food = 10;
    //函数：输入int，输出int
    public int eat(Dog this,int num){
        System.out.println("eat:"+num+"kg");
        this.food-=num;
        return this.food;

    }
}
public class MethodLearn {
    public static void main(String[] args) {
        Consumer<Dog> consumer = Dog::Bark;
        consumer.accept(new Dog());
        Dog dog = new Dog();

        //输入和输出同类型
        IntUnaryOperator eat = dog::eat;
        dog=null;
        System.out.println("还剩下"+eat.applyAsInt(3));
        BiFunction<Dog,Integer,Integer> eatFunc = Dog::eat;
        System.out.println("还有"+eatFunc.apply(new Dog(),2 ));
        Supplier<Dog> supplier = Dog::new;
        Function<Integer,Dog> dog2 = Dog::new;

    }
}
