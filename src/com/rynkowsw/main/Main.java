package com.rynkowsw.main;

import com.rynkowsw.camera.Camera;
import com.rynkowsw.model.Vector3d;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import com.rynkowsw.paint.Jpanel;
import com.rynkowsw.paint.TkeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Main extends JFrame {

    private Jpanel jp;

    public Main() {

        initUI();
        getDate();
        setJpanel();
        setListener();
    }

    private void initUI() {

        setTitle("Grafika");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
        this.setVisible(true);
        setSize(500, 500);

        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void setJp(Jpanel jp) {
        this.jp = jp;
    }

    private void setListener() {
        TkeyListener keyListener = new TkeyListener(jp);
        this.addKeyListener(keyListener);
    }

    private void setJpanel() {
        Jpanel jpa = new Jpanel(getDate());
        this.setJp(jpa);
        add(jpa);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                Main js = new Main();
                js.setVisible(true);
            }
        });
    }

    private ArrayList<Vector3d> getDate() {
        return Utils.getVectorsFromFile();
    }
}
