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
public class moveDown implements OperationInterface {

    private ArrayList<Vector3d> moveDown(ArrayList<Vector3d> vectors) {
        for (Vector3d it : vectors) {
            it.getA().setZ(it.getA().getZ() + Utils.TRANSLATION_STEP);
            it.getB().setZ(it.getB().getZ() + Utils.TRANSLATION_STEP);
        }
        return vectors;
    }

    public ArrayList<Vector3d> makeOperation(ArrayList<Vector3d> vectors) {
        return moveDown(vectors);
    }
}
