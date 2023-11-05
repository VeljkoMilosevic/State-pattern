package process;


import exceptions.IllegalStateTransfer;
import states.AcceptedState;
import states.CancelState;
import states.RejectState;
import states.ReviewState;
import states.State;
import states.WritingState;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Veljko
 */
public class PaperReviewProcess {

    private List<State> nonFinalStates;
    private List<State> finalStates;
    private State currentState;

    public void initialize() {
        createAllFinalStates();
        createAllNonFinalStates();
        addNextStates();
        setInitCurrentState();
    }

    private void addNextStates() {
        for (final State state : nonFinalStates) {
            state.setNextStates();
        }
    }

    private void setInitCurrentState() {
        currentState = WritingState.getInstance();
    }

    private void createAllFinalStates() {
        finalStates = new LinkedList<>();
        finalStates.add(CancelState.getInstance());
        finalStates.add(AcceptedState.getInstance());
        finalStates.add(RejectState.getInstance());
    }

    private void createAllNonFinalStates() {
        nonFinalStates = new LinkedList<>();
        nonFinalStates.add(WritingState.getInstance());
        nonFinalStates.add(ReviewState.getInstance());
    }

    public void changeState(final State state) throws IllegalStateTransfer {
        if (!currentState.getNextStates().contains(state) || finalStates.contains(currentState)) {
            throw new IllegalStateTransfer();
        }
        this.currentState = state;
    }

    public void handleRequest() {
        currentState.handleRequest();
    }


    public List<State> getNonFinalStates() {
        return nonFinalStates;
    }

    public List<State> getFinalStates() {
        return finalStates;
    }

    public State getCurrentState() {
        return currentState;
    }

    public boolean isCurrentStateFinal() {
        return finalStates.contains(currentState);
    }
}
