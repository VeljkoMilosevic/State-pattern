/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import process.PaperReviewProcess;
import states.State;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

/**
 * @author Veljko
 */
public class Component {

    protected static final int X_LOCATION_DISLOCATION = 100;
    protected static final int Y_LOCATION_DISLOCATION = 50;
    protected static final int X_LOCATION_NAME_DISLOCATION = 15;
    protected static final int Y_LOCATION_NAME_DISLOCATION = 50;

    protected State state;
    protected int x;
    protected int y = 100;
    protected int width = 100;
    protected int height = 100;
    protected PaperReviewProcess paperReviewProcess;

    public Component(final State state, final int x, final PaperReviewProcess paperReviewProcess) {
        this.state = state;
        this.x = x;
        this.paperReviewProcess = paperReviewProcess;
    }

    //@Override
    public void paint(final Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawOval(x, y, width, height);
        if (state.equals(paperReviewProcess.getCurrentState())) {
            graphics.setColor(Color.GREEN);
        }
        graphics.fillOval(x, y, width, height);
        graphics.setColor(Color.black);
        graphics.drawString(state.toString(), x + X_LOCATION_NAME_DISLOCATION, y + Y_LOCATION_NAME_DISLOCATION);
    }

    public State getState() {
        return state;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Component other = (Component) obj;
        return Objects.equals(this.state, other.state);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.state);
        hash = 31 * hash + this.x;
        hash = 31 * hash + this.y;
        hash = 31 * hash + this.width;
        hash = 31 * hash + this.height;
        hash = 31 * hash + Objects.hashCode(this.paperReviewProcess);
        return hash;
    }

    public int getLocationX() {
        return x + X_LOCATION_DISLOCATION;
    }

    public int getLocationY() {
        return y + Y_LOCATION_DISLOCATION;
    }
}
