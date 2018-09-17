public class TheadDemo extends Thread {

    public static void main(String[] args) {
        TheadDemo mt1= new TheadDemo("一号窗口");
        TheadDemo mt2= new TheadDemo("二号窗口");
        TheadDemo mt3= new TheadDemo("三号窗口");
        TheadDemo mt4= new TheadDemo("三号窗口");
        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
    }

    private int ticket = 100;
    private String name;

    public TheadDemo(String name) {
        this.name = name;
    }

    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            if (this.ticket > 0) {
                System.out.println(this.name + "卖票---->" + (this.ticket--));
                System.out.println(Math.round(11.5));
            }
        }
    }

}
