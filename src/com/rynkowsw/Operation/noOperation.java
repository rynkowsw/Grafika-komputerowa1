/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rynkowsw.Operation;

import com.rynkowsw.model.Vector3d;
import java.util.ArrayList;

/**
 *
 * @author WR
 */
public class noOperation implements OperationInterface {

    @Override
    public ArrayList<Vector3d> makeOperation(ArrayList<Vector3d> vectors) {
        return vectors;
    }

}
