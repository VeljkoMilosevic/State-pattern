/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Veljko
 */
public abstract class State {

    protected List<State> nextStates;

    protected State() {
        nextStates = new LinkedList<>();
    }

    public List<State> getNextStates() {
        return nextStates;
    }

    public abstract void setNextStates();

    public abstract String handleRequest();

}
