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

/**
 * @author Veljko
 */
public class FinalComponent extends Component {

    private static final int Y_START_LOCATION = 300;
    private static final int COMPONENT_WIDTH = 50;
    private static final int COMPONENT_HEIGHT = 50;
    private static final int X_LOCATION_DISLOCATION = 25;

    private static final int RELATIVE_X_LOCATION_DOT = 15;

    private static final int RELATIVE_Y_LOCATION_DOT = 15;

    private static final int DOT_SIZE_WIDTH = 20;

    private static final int DOT_SIZE_HEIGHT = 20;

    private static final int RELATIVE_X_LOCATION_NAME = 15;

    private static final int RELATIVE_Y_LOCATION_NAME = 70;


    public FinalComponent(final State state, final int x, final PaperReviewProcess paperReviewProcess) {
        super(state, x, paperReviewProcess);
        y = Y_START_LOCATION;
    }

    @Override
    public void paint(final Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.drawOval(x, y, COMPONENT_WIDTH, COMPONENT_HEIGHT);
        if (state.equals(paperReviewProcess.getCurrentState())) {
            graphics.setColor(Color.GREEN);
            graphics.fillOval(x, y, COMPONENT_WIDTH, COMPONENT_HEIGHT);
        }
        graphics.setColor(Color.black);
        graphics.fillOval(x + RELATIVE_X_LOCATION_DOT,
                y + RELATIVE_Y_LOCATION_DOT, DOT_SIZE_WIDTH,
                DOT_SIZE_HEIGHT);
        graphics.drawString(state.toString(),
                x - RELATIVE_X_LOCATION_NAME, y + RELATIVE_Y_LOCATION_NAME);
    }

    @Override
    public int getLocationX() {
        return x + X_LOCATION_DISLOCATION;
    }

    @Override
    public int getLocationY() {
        return y;
    }

}
