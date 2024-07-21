// 6510405601 Teerut Srithongdee
package controller;

import state.*;

public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State hasChosenFlavorState;
    State soldState;

    State state;
    int count = 0;
    String chosenFlavor = "";

    public GumballMachine(int numGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        hasChosenFlavorState = new HasChosenFlavorState(this);
        soldState = new SoldState(this);

        this.count = numGumballs;
        if (numGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void chooseFlavor(String flavor) {
        state.chooseFlavor(flavor);
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    public int getCount() {
        return count;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setChosenFlavor(String flavor) {
        this.chosenFlavor = flavor;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getHasChosenFlavorState() {
        return hasChosenFlavorState;
    }

    public State getSoldState() {
        return soldState;
    }

    public String toString() {
        String machineDescribe = "\nMachine is " + state;

        return "Mighty Gumball, Inc." +
                "\nJava-enabled Standing Gumball Model #2004" +
                "\nInventory: " + count + " gumball" + (count != 1 ? "s" : "") + "" +
                machineDescribe;
    }

}
