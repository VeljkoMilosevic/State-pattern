/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

/**
 * @author Veljko
 */
public class WritingState extends State {

    private static final State INSTANCE;

    static {
        INSTANCE = new WritingState();
    }

    public static State getInstance() {
        return INSTANCE;
    }

    private WritingState() {
    }

    @Override
    public void setNextStates() {
        nextStates.add(this);
        nextStates.add(CancelState.getInstance());
        nextStates.add(ReviewState.getInstance());
    }

    @Override
    public String toString() {
        return "Writing State";
    }

    @Override
    public String handleRequest() {
        return "Paper is in writing process!";
    }

}
