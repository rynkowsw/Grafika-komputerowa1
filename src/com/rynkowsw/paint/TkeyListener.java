/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rynkowsw.paint;

import com.rynkowsw.Operation.OperationInterface;
import com.rynkowsw.Operation.moveBackward;
import com.rynkowsw.Operation.moveDown;
import com.rynkowsw.Operation.moveForward;
import com.rynkowsw.Operation.moveLeft;
import com.rynkowsw.Operation.moveRight;
import com.rynkowsw.Operation.moveUp;
import com.rynkowsw.Operation.noOperation;
import com.rynkowsw.Operation.rotateDown;
import com.rynkowsw.Operation.rotateLeft;
import com.rynkowsw.Operation.rotateRight;
import com.rynkowsw.Operation.rotateUp;
import com.rynkowsw.model.Vector3d;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author WR
 */
public class TkeyListener implements KeyListener {

    public TkeyListener(Jpanel panel) {
        this.jp = panel;
    }

    private Jpanel jp;

    public void keyTyped(KeyEvent e) {
        action(e);
    }

    public void keyPressed(KeyEvent e) {
        action(e);
    }

    public void keyReleased(KeyEvent e) {
        action(e);
    }

    private void action(KeyEvent e) {

        int id = e.getID();
        String keyString, s;
        int keyCode = e.getKeyCode();
        keyString = "key code = " + keyCode + " (" + KeyEvent.getKeyText(keyCode) + ")";
        System.err.println(keyString);
        operation(keyCode);
    }

    void operation(int keyCode) {
        OperationInterface operation = operation = new noOperation();
        switch (keyCode) {
            case 65: //a
                operation = new moveLeft();
                break;
            case 68: //d
                operation = new moveRight();
                break;
            case 87: //w
                operation = new moveForward();
                break;
            case 83: //s
                operation = new moveBackward();
                break;
            case 82: //r
                operation = new moveUp();
                break;
            case 70: //f
                operation = new moveDown();
                break;
            case 37: //q
                operation = new rotateLeft();
                break;
            case 39: //e
                operation = new rotateRight();
                break;
            case 38: //q
                operation = new rotateUp();
                break;
            case 40: //e
                operation = new rotateDown();
                break;
            case 84: //t
                jp.camera.zoomIn();
                break;
            case 71: //g
                jp.camera.zoomOut();
                break;
        }
        repaint(operation);
    }

    void repaint(OperationInterface operation) {
        System.out.println(operation.toString());
        jp.setVectors3d(operation.makeOperation(jp.getVectors3d()));
        jp.repaintVector();
    }

    public Jpanel getJp() {
        return jp;
    }

    public void setJp(Jpanel jp) {
        this.jp = jp;
    }
}
