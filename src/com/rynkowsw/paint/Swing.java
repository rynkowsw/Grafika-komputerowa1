package com.rynkowsw.paint;

import com.rynkowsw.camera.Camera;
import com.rynkowsw.camera.Operation;
import com.rynkowsw.model.Punkt2d;
import com.rynkowsw.model.Vector2d;
import com.rynkowsw.model.Vector3d;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.accessibility.AccessibleContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

class Jpanel extends JPanel {

    Jpanel() {
        Utils u = new Utils();
        this.operation = new Operation(u.getVectorsFromFile(), new Camera());
        this.vectors2d = operation.makeProjection();
    }
    ArrayList<Vector2d> vectors2d = null;
    Operation operation;

    public void repaintVector() {
        this.vectors2d = operation.makeProjection();
        repaint();
    }

    private void drawVectors2d(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Punkt2d p1, p2;
        Double x1, x2, y1, y2;
        if (vectors2d == null) {
            System.out.println("Brak danych");
            System.exit(-1);
        } else {
            for (Vector2d it : vectors2d) {
                p1 = it.getA();
                p2 = it.getB();
                x1 = p1.getX();
                x2 = p2.getX();
                y1 = p1.getY();
                y2 = p2.getY();
                g2d.drawLine(x1.intValue(), y1.intValue(), x2.intValue(), y2.intValue());
            }
        }

    }

    public void setVectors2d(ArrayList<Vector2d> vectors2d) {
        this.vectors2d = vectors2d;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

    public ArrayList<Vector2d> getVectors2d() {
        return vectors2d;
    }

    public Operation getOperation() {
        return operation;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public static int getWHEN_FOCUSED() {
        return WHEN_FOCUSED;
    }

    public static int getWHEN_ANCESTOR_OF_FOCUSED_COMPONENT() {
        return WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
    }

    public static int getWHEN_IN_FOCUSED_WINDOW() {
        return WHEN_IN_FOCUSED_WINDOW;
    }

    public static int getUNDEFINED_CONDITION() {
        return UNDEFINED_CONDITION;
    }

    public static String getTOOL_TIP_TEXT_KEY() {
        return TOOL_TIP_TEXT_KEY;
    }

    public static float getTOP_ALIGNMENT() {
        return TOP_ALIGNMENT;
    }

    public static float getCENTER_ALIGNMENT() {
        return CENTER_ALIGNMENT;
    }

    public static float getBOTTOM_ALIGNMENT() {
        return BOTTOM_ALIGNMENT;
    }

    public static float getLEFT_ALIGNMENT() {
        return LEFT_ALIGNMENT;
    }

    public static float getRIGHT_ALIGNMENT() {
        return RIGHT_ALIGNMENT;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawVectors2d(g);
    }
}

public class Swing extends JFrame {

    Jpanel jp;

    class TkeyListener implements KeyListener {

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
            switch (keyCode) {
                case 65: //a
                    jp.operation.moveLeft();
                    break;
                case 68: //d
                    jp.operation.moveRight();
                    break;
                case 87: //w
                    jp.operation.moveForward();
                    break;
                case 83: //s
                    jp.operation.moveBackward();
                    break;
                case 82: //r
                    jp.operation.moveUp();
                    break;
                case 70: //f
                    jp.operation.moveDown();
                    break;
                case 81: //q
                    jp.operation.rotateLeft();
                    break;
                case 69: //e
                    jp.operation.rotateRight();
                    break;
                case 80: //e
                    jp.operation.printVectors();
                    break;
            }
            jp.repaintVector();
        }
    }

    public Swing() {

        initUI();
    }

    private void initUI() {

        setTitle("Grafika");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TkeyListener keyListener = new TkeyListener();
        this.addKeyListener(keyListener);
        jp = new Jpanel();
        add(jp);
        this.setFocusable(true);
        this.setVisible(true);
        setSize(500, 500);

        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                Swing js = new Swing();
                js.setVisible(true);
            }
        });
    }

}
