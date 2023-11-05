/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import events.ListenerMouse;
import process.PaperReviewProcess;
import states.State;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Veljko
 */
public class FrmMain extends JFrame {

    private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 500;
    private static final int START_X_POSITION = 100;
    private static final int X_POSITION_DISLOCATION = 150;

    private static final int START_ANGLE = 0;
    private static final int ARCH_ANGLE = 180;
    private static final int THREE_POINTS = 3;

    private transient PaperReviewProcess paperReviewProcess;
    private transient List<Component> components;
    private transient List<FinalComponent> finalComponents;
    private transient Line line;
    private transient ListenerMouse listenerMouse;

    public FrmMain() throws HeadlessException {
        initPaperReviewProcess();
        initStates();
        setListener();
        setSize();
        setCloseOperation();
    }

    private void initStates() {
        components = new LinkedList<>();
        finalComponents = new LinkedList<>();
        listenerMouse = new ListenerMouse(this);
    }

    private void initPaperReviewProcess() {
        paperReviewProcess = new PaperReviewProcess();
        paperReviewProcess.initialize();
    }

    @Override
    public void paint(final Graphics graphics) {
        drawNonFinalStates(graphics);
        drawFinalStates(graphics);
        draw(graphics);

        for (final Component component : components) {
            drawComponentConnections(graphics, component);
        }

        for (final Component component : components) {
            for (final State s : component.getState().getNextStates()) {
                for (final FinalComponent finalComponent : finalComponents) {
                    if (s.equals(finalComponent.getState())) {
                        line = new Line(finalComponent, component);
                        line.paintFinalComponentLine(graphics);
                    }
                }
            }
        }
    }

    private void drawNonFinalStates(final Graphics graphics) {
        int x = START_X_POSITION;
        for (final State state :
                paperReviewProcess.getNonFinalStates()) {
            final Component component = new Component(state, x,
                    paperReviewProcess);
            component.paint(graphics);
            if (!components.contains(component)) {
                components.add(component);
            }
            x += X_POSITION_DISLOCATION;
        }
    }

    private void drawFinalStates(final Graphics graphics) {
        int x = X_POSITION_DISLOCATION;
        for (final State state : paperReviewProcess.getFinalStates()) {
            final FinalComponent finalComponent =
                    new FinalComponent(state, x,
                            paperReviewProcess);
            finalComponent.paint(graphics);
            if (!finalComponents.contains(finalComponent)) {
                finalComponents.add(finalComponent);
            }
            x += X_POSITION_DISLOCATION;
        }
    }

    private void drawComponentConnections(final Graphics graphics, final Component component) {
        for (final State state : component.getState().getNextStates()) {
            if (component.getState().equals(state)) {
                drawLineToSelf(graphics, component);
            }

            for (final Component connectingComponent :
                    components) {
                if (!connectingComponent.equals(component) && state.equals(connectingComponent.getState())) {
                    line = new Line(component, connectingComponent);
                    line.paintLine(graphics);
                }
            }
        }
    }

    private void drawLineToSelf(final Graphics graphics, final Component component) {
        graphics.drawArc(component.getLocationX() - 60,
                50, 20, 100, START_ANGLE, ARCH_ANGLE);
        final int[] xPoints =
                new int[]{component.getLocationX() - 60, component.getLocationX() - 60 - 8, component.getLocationX() - 60 + 8};
        final int[] yPoints = new int[]{100, 100 - 8, 100 - 8};
        graphics.fillPolygon(xPoints, yPoints, THREE_POINTS);
    }

    private void draw(final Graphics graphics) {
        for (final Component component : components) {
            for (final State state : component.getState().getNextStates()) {
                if (component.getState().equals(state)) {
                    graphics.drawArc(component.getLocationX() - 60,
                            50, 20, 100, START_ANGLE, ARCH_ANGLE);
                    final int[] xPoints = new int[]{component.getLocationX() - 60, component.getLocationX() - 60 - 8, component.getLocationX() - 60 + 8};
                    final int[] yPoints = new int[]{100, 100 - 8, 100 - 8};
                    graphics.fillPolygon(xPoints, yPoints, THREE_POINTS);
                }
                for (final Component k1 : components) {
                    if (!k1.equals(component) && state.equals(k1.getState())) {
                        line = new Line(component, k1);
                        line.paintLine(graphics);
                    }
                }
            }
        }
    }

    private void setListener() {
        this.addMouseListener(listenerMouse);
    }

    private void setSize() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public PaperReviewProcess getPaperReviewProcess() {
        return paperReviewProcess;
    }

    void changeState(final State state) {
        this.paperReviewProcess.changeState(state);
        this.repaint();
        JOptionPane.showMessageDialog(this,
                paperReviewProcess.getCurrentState().handleRequest());
        if (this.paperReviewProcess.isCurrentStateFinal()) {
            JOptionPane.showMessageDialog(this, "You are in final state. End of simulation.");
            this.dispose();
        }
    }

    private void setCloseOperation() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
