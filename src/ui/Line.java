/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Graphics;


/**
 * @author Veljko
 */
public class Line {

    private static final int X_LINE_DISLOCATION = 100;

    private static final int X_LINE_POINTER = 8;
    private static final int Y_LINE_POINTER = 8;

    private static final int POINTER_NUMBER_OF_LINES = 3;

    private final Component component1;
    private final Component component2;

    public Line(final Component component1, final Component component2) {
        this.component1 = component1;
        this.component2 = component2;
    }

    public void paintLine(final Graphics g) {
        if (component2.getLocationX() > component1.getLocationX()) {
            g.drawLine(component2.getLocationX() - X_LINE_DISLOCATION, component2.getLocationY(), component1.getLocationX(), component1.getLocationY());

            final int[] xPoints = new int[]{component1.getLocationX(),
                    component1.getLocationX() + X_LINE_POINTER,
                    component1.getLocationX() + Y_LINE_POINTER};
            final int[] yPoints = new int[]{component1.getLocationY(),
                    component1.getLocationY() + X_LINE_POINTER, component1.getLocationY() - Y_LINE_POINTER};
            g.fillPolygon(xPoints, yPoints, POINTER_NUMBER_OF_LINES);
        } else {
            g.drawLine(component1.getLocationX() - X_LINE_DISLOCATION, component1.getLocationY(), component2.getLocationX(), component2.getLocationY());

            final int[] xPoints =
                    new int[]{component1.getLocationX() - X_LINE_DISLOCATION,
                            component1.getLocationX() - X_LINE_DISLOCATION - X_LINE_POINTER, component1.getLocationX() - X_LINE_DISLOCATION - Y_LINE_POINTER};
            final int[] yPoints = new int[]{component1.getLocationY(),
                    component1.getLocationY() + X_LINE_POINTER, component1.getLocationY() - Y_LINE_POINTER};
            g.fillPolygon(xPoints, yPoints, POINTER_NUMBER_OF_LINES);
        }
    }

    public void paintFinalComponentLine(final Graphics g) {
        g.drawLine(component2.getLocationX(), component2.getLocationY(), component1.getLocationX(), component1.getLocationY());
        final int[] xPoints = new int[]{component1.getLocationX(), component1.getLocationX() - X_LINE_POINTER, component1.getLocationX() + Y_LINE_POINTER};
        final int[] yPoints = new int[]{component1.getLocationY(),
                component1.getLocationY() - X_LINE_POINTER,
                component1.getLocationY() - Y_LINE_POINTER};
        g.fillPolygon(xPoints, yPoints, POINTER_NUMBER_OF_LINES);
    }
}
    

