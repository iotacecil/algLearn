package javaquickTest.lambdaStream;

@FunctionalInterface
interface IMath{
    int add(int x,int y);
}
public class TypeLearn {
    //变量类型定义
    IMath lambda = (x,y)->x+y;
    IMath[] lambdas = {(x,y)->x+y};

    Object lambda2 = (IMath)(x,y)->x+y;

    IMath createLambda = createLambda();
    private IMath createLambda(){
        return (x,y)->x+y;
    }

//    TypeLearn demo = new TypeLearn();
//    demo.test((x,y)->x+y);
//    public void test(IMath math){
//
//    }
    public static void main(String[] args) {

    }
}
