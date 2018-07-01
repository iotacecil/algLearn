package leetcode;


public class Person {
	//添加了name，sex，示加private修饰，同包类能访问
	String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public boolean isSame(Person person){
		//如果名字相同返回true,其它情况返回false
		if(this.name.equals(person.name)){
			return true;
		}
		return false;
	}
	
//	@Override
//	public boolean equals(Person other) {
//		//重用了String的equals方法，如果两个人名字相同，那我们认为这两个对象代表同一个人。
//		return name.equals(name);
//	}
	
//	注意最好加上@Override,加上是让编译器帮你检查是否真的覆盖了父类方法
	@Override
	public boolean equals(Object other) {
		//先判断是否是同一个对象，如果是直接返回true
		if (this == other) {
			return true;
		}
		//判断other是否是类Person的实例
		if (other instanceof Person) {
			Person otherPerson = (Person)other;//如果是Person的实例，转换为Person类型
			return name.equals(otherPerson.name);//利用name（String）本身的equals来比较。
		}
		return false;//其它情况返回false
	}
	
//	@Override
//	public int hashCode() {
//		//重写hashCode方法，这儿我们和equals一样，直接返回name的hashCode
//		return name.hashCode();
//	}
//	
}
