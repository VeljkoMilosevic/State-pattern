/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

/**
 * @author Veljko
 */
public class AcceptedState extends State {

    private static final State INSTANCE;

    static {
        INSTANCE = new AcceptedState();
    }

    private AcceptedState() {
    }

    public static State getInstance() {
        return INSTANCE;
    }

    @Override
    public void setNextStates() {
    }

    @Override
    public String toString() {
        return "Accepted State";
    }

    @Override
    public String handleRequest() {
        return "Paper is accepted!";
    }


}
