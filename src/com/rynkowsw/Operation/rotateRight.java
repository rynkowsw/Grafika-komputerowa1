/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rynkowsw.Operation;

import com.rynkowsw.main.Utils;
import com.rynkowsw.model.Vector3d;
import java.util.ArrayList;

/**
 *
 * @author WR
 */
public class rotateRight implements OperationInterface {

    private ArrayList<Vector3d> rotateRight(ArrayList<Vector3d> vectors) {
        double ax, ay, bx, by;
        for (Vector3d it : vectors) {
            ax = it.getA().getX();
            ay = it.getA().getY();
            bx = it.getB().getX();
            by = it.getB().getY();

            it.getA().setX((ax * java.lang.Math.cos(Utils.ROTATE_STEP)) - (ay * java.lang.Math.sin(Utils.ROTATE_STEP)));
            it.getA().setY((ax * java.lang.Math.sin(Utils.ROTATE_STEP)) + (ay * java.lang.Math.cos(Utils.ROTATE_STEP)));

            it.getB().setX((bx * java.lang.Math.cos(Utils.ROTATE_STEP)) - (by * java.lang.Math.sin(Utils.ROTATE_STEP)));
            it.getB().setY((bx * java.lang.Math.sin(Utils.ROTATE_STEP)) + (by * java.lang.Math.cos(Utils.ROTATE_STEP)));
        }
        return vectors;
    }

    public ArrayList<Vector3d> makeOperation(ArrayList<Vector3d> vectors) {
        return rotateRight(vectors);
    }
}
