package LLD.BehaviouralDesignPattern;


/*
The State design pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes.
This pattern is particularly useful when an object needs to exhibit different behaviors based on its current state.
By encapsulating state-specific behavior into separate state objects, the State pattern promotes a cleaner and more maintainable design.
 */
// State interface
interface State {
    void execute();
}

// Concrete State: NoCoinState
class StateA implements State {
    private Context context;

    public StateA(Context context) {
        this.context = context;
    }

    @Override
    public void execute() {
        System.out.println("StateA Execute");
        context.setState(context.getStateB());
    }
}

// Concrete State: HasCoinState
class StateB implements State {
    private final Context context;

    public StateB(Context context) {
        this.context = context;
    }

    @Override
    public void execute() {
        System.out.println("StateB execute");
        context.setState(null);
    }
}

// Context
class Context {
    private State stateA;
    private State stateB;

    private State currentState;

    public Context() {
        stateA = new StateA(this);
        stateB = new StateB(this);

        currentState = stateA;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getStateA() {
        return stateA;
    }

    public State getStateB() {
        return stateB;
    }

    public void pressButton() {
        if (currentState == null){
            System.out.println("end");
            return;
        }
        currentState.execute();
    }
}

// Main class
public class StateExample {
    public static void main(String[] args) {
        Context context = new Context();

        context.pressButton();
        context.pressButton();
        context.pressButton();

    }
}
