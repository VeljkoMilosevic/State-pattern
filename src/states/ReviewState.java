/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

/**
 * @author Veljko
 */
public class ReviewState extends State {

    private static final State INSTANCE;

    static {
        INSTANCE = new ReviewState();
    }

    private ReviewState() {
    }

    public static State getInstance() {
        return INSTANCE;
    }

    @Override
    public void setNextStates() {
        nextStates.add(AcceptedState.getInstance());
        nextStates.add(WritingState.getInstance());
        nextStates.add(RejectState.getInstance());
    }

    @Override
    public String toString() {
        return "Review State";
    }

    @Override
    public String handleRequest() {
        return "Paper is in review process!";
    }


}
