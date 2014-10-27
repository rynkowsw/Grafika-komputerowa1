/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rynkowsw.paint;

import com.rynkowsw.model.Punkt2d;
import com.rynkowsw.model.Vector2d;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author WR
 */
public class Paint_Segments {

    private Graphics graphic;

    public void setGraphic(Graphics graphic) {
        this.setGraphic(graphic);
    }

    public Graphics getGraphic() {
        return graphic;
    }

    public Paint_Segments(Graphics graphic) {
        this.graphic = graphic;
    }

    public void drawVectors2d(ArrayList<Vector2d> vectors2d) {
        Graphics2D g2d = (Graphics2D) graphic;
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
}
