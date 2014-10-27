/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rynkowsw.paint;

import com.rynkowsw.Operation.ProjectionInterface;
import com.rynkowsw.Operation.noOperation;
import com.rynkowsw.main.Utils;
import com.rynkowsw.camera.Camera;
import com.rynkowsw.model.Vector2d;
import com.rynkowsw.model.Vector3d;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author WR
 */
public class Jpanel extends JPanel implements ProjectionInterface {

    Camera camera;

    public Jpanel(ArrayList<Vector3d> vectors3d) {
        this.vectors3d = vectors3d;
        this.camera = new Camera();
    }
    private ArrayList<Vector3d> vectors3d;

    public void repaintVector() {
        repaint();
    }

    public ArrayList<Vector3d> getVectors3d() {
        return vectors3d;
    }

    public void setVectors3d(ArrayList<Vector3d> vectors3d) {
        this.vectors3d = vectors3d;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Paint_Segments painter = new Paint_Segments(g);
        System.out.println(camera.toString() + '\n' + vectors3d.toString());
        System.out.println(camera.toString() + "dsdsd \n" + vectors3d.toString());
        painter.drawVectors2d(this.makeProjection(vectors3d, camera));
    }
    private static final Logger LOG = Logger.getLogger(Jpanel.class.getName());

}
