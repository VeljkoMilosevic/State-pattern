/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

/**
 * @author Veljko
 */
public class CancelState extends State {

    private static final State INSTANCE;

    static {
        INSTANCE = new CancelState();
    }

    private CancelState() {
    }

    public static State getInstance() {
        return INSTANCE;
    }

    @Override
    public void setNextStates() {
    }

    @Override
    public String toString() {
        return "Cancel State";
    }

    @Override
    public String handleRequest() {
        return "Paper is canceled!";
    }

}
