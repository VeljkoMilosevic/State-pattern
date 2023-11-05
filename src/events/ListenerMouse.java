/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import ui.FrmChoice;
import ui.FrmMain;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Veljko
 */
public class ListenerMouse extends MouseAdapter {

    private final FrmMain frmMain;

    public ListenerMouse(final FrmMain frmMain) {
        this.frmMain = frmMain;
    }


    @Override
    public void mouseClicked(final MouseEvent e) {
        new FrmChoice(frmMain).setVisible(true);
    }
}
