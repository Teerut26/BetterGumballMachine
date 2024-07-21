// 6510405601 Teerut Srithongdee

package state;
import controller.GumballMachine;
import java.util.Random;

public class SoldState implements State {
    GumballMachine gumballMachine;
    Random randomWinner = new Random(System.currentTimeMillis());

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            int winner = randomWinner.nextInt(10);
            if (winner == 0 && gumballMachine.getCount() > 0) {
                System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter");
                gumballMachine.releaseBall();
            }
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }

    public void chooseFlavor(String flavor) {
        System.out.println("Please wait, we're already giving you a gumball");
    }
}
