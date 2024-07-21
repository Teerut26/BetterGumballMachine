// 6510405601 Teerut Srithongdee
package state;

public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
    void chooseFlavor(String flavor);
}
