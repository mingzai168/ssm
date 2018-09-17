public class TestAbstract {
    public static void main(String[] args) {
        //抽象类
        //  Super1 s = new Super1();    //error， abstract修饰的类不能被创建对象 不可被实例化，抽象类只能声明引用，不能创建对象
        Sub sub = new Sub();       //Sub继承了abstract修饰的类，但可以创建对象
        Super1 s1 = new Sub();  //但Super1可以指向子类引用
    }
    }



abstract class Super1 { }
class Sub extends Super1 { }