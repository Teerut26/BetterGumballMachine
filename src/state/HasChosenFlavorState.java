// 6510405601 Teerut Srithongdee
package state;

import controller.GumballMachine;

public class HasChosenFlavorState implements State {
    GumballMachine gumballMachine;

    public HasChosenFlavorState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
        gumballMachine.getState().dispense();
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    public void chooseFlavor(String flavor) {
        System.out.println("You have chosen the flavor " + flavor);
        gumballMachine.setChosenFlavor(flavor);
    }
}
