class  animal{
    String name;
    int age;
    public void eat(){
        System.out.println(name+"吃");
    }
}
class  cat extends animal{
    cat(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void eat(){
        System.out.println(name+"吃"+"猫粮");
    }
}

public class test2 {
    public static void main(String[] args) {
        cat cat =  new cat("小猫",1);
        cat.eat();
    }
}
