// 6510405601 Teerut Srithongdee
import controller.GumballMachine;

public class Main {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(10);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.chooseFlavor("Mango");
        gumballMachine.chooseFlavor("Orange");
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }
}

// 4. การออกแบบตาม design pattern คิดว่ามันมีข้อดีเพราะว่าเราสามารถจัดการ code ได้ง่ายขึ้น เมื่อเราต้องการที่จะเพิ่ม feature
