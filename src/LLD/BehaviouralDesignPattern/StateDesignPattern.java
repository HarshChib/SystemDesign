package LLD.BehaviouralDesignPattern;

/*
The State design pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes.
This pattern is particularly useful when an object needs to exhibit different behaviors based on its current state.
By encapsulating state-specific behavior into separate state objects, the State pattern promotes a cleaner and more maintainable design.
 */
// State interface
interface VendingMachineState {
    void insertCoin();
    void pressButton();
    void dispense();
}

// Concrete State: NoCoinState
class NoCoinState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public NoCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted.");
        vendingMachine.setState(vendingMachine.getHasCoinState());
    }

    @Override
    public void pressButton() {
        System.out.println("No coin inserted.");
    }

    @Override
    public void dispense() {
        System.out.println("No coin inserted.");
    }
}

// Concrete State: HasCoinState
class HasCoinState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted.");
    }

    @Override
    public void pressButton() {
        System.out.println("Button pressed.");
        vendingMachine.setState(vendingMachine.getDispensingState());
    }

    @Override
    public void dispense() {
        System.out.println("Press the button to dispense.");
    }
}

// Concrete State: DispensingState
class DispensingState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait. Dispensing in progress.");
    }

    @Override
    public void pressButton() {
        System.out.println("Already dispensing.");
    }

    @Override
    public void dispense() {
        System.out.println("Dispensing item.");
        vendingMachine.setState(vendingMachine.getNoCoinState());
    }
}

// Concrete State: OutOfStockState
class OutOfStockState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public OutOfStockState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Out of stock.");
    }

    @Override
    public void pressButton() {
        System.out.println("Out of stock.");
    }

    @Override
    public void dispense() {
        System.out.println("Out of stock.");
    }
}

// Context
class VendingMachine {
    private VendingMachineState noCoinState;
    private VendingMachineState hasCoinState;
    private VendingMachineState dispensingState;
    private VendingMachineState outOfStockState;

    private VendingMachineState currentState;

    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        dispensingState = new DispensingState(this);
        outOfStockState = new OutOfStockState(this);

        currentState = noCoinState;
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getNoCoinState() {
        return noCoinState;
    }

    public VendingMachineState getHasCoinState() {
        return hasCoinState;
    }

    public VendingMachineState getDispensingState() {
        return dispensingState;
    }

    public VendingMachineState getOutOfStockState() {
        return outOfStockState;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void pressButton() {
        currentState.pressButton();
        currentState.dispense();
    }
}

// Main class
public class StateDesignPattern {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.insertCoin();
        vendingMachine.insertCoin();
        vendingMachine.pressButton();

        vendingMachine.insertCoin();
        vendingMachine.pressButton();
    }
}
