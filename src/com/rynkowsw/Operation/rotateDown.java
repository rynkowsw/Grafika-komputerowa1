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
public class rotateDown implements OperationInterface {

    private ArrayList<Vector3d> rotateDown(ArrayList<Vector3d> vectors) {
        double ay, az, by, bz;
        for (Vector3d it : vectors) {

            ay = it.getA().getY();
            az = it.getA().getZ();
            by = it.getB().getY();
            bz = it.getB().getZ();

            it.getA().setY((ay * java.lang.Math.cos(Utils.ROTATE_STEP)) - (az * java.lang.Math.sin(Utils.ROTATE_STEP)));
            it.getA().setZ((ay * java.lang.Math.sin(Utils.ROTATE_STEP)) + (az * java.lang.Math.cos(Utils.ROTATE_STEP)));

            it.getB().setY((by * java.lang.Math.cos(Utils.ROTATE_STEP)) - (bz * java.lang.Math.sin(Utils.ROTATE_STEP)));
            it.getB().setZ((by * java.lang.Math.sin(Utils.ROTATE_STEP)) + (bz * java.lang.Math.cos(Utils.ROTATE_STEP)));

        }
        return vectors;
    }

    @Override
    public ArrayList<Vector3d> makeOperation(ArrayList<Vector3d> vectors) {
        return rotateDown(vectors);
    }
}
