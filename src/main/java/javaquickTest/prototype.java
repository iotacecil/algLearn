package javaquickTest;

import java.text.MessageFormat;

class WorkExperience implements Cloneable{
    public String workDate;


    @Override
    public Object clone() {
        WorkExperience obj = new WorkExperience();
        obj.workDate = this.workDate;
        return obj;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "workDate='" + workDate + '\'' +
                '}';
    }
}
class Resume implements Cloneable {
    private String name;
    private WorkExperience work;


    private Resume(WorkExperience work)
    {
        this.work = (WorkExperience) work.clone();
    }

    public Resume(String name) {
        this.name = name;
        this.work = new WorkExperience();
    }
    public void SetDate(String date){
        this.work.workDate = date;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {

       Resume obj = (Resume) super.clone();
       obj.work = (WorkExperience) work.clone();
        return obj;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", work=" + work.toString() +
                '}';
    }
}
public class prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume a = new Resume("张三");
        a.SetDate("aaa");
        Resume b = (Resume)a.clone();
        b.SetDate("bbb");
        System.out.println(a);
        System.out.println(b);
        String content = "向{0}同学";
        System.out.println(MessageFormat.format(content, "bbb"));
    }


}
