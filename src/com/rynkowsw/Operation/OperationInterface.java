/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rynkowsw.Operation;

import com.rynkowsw.camera.Camera;
import com.rynkowsw.main.Utils;
import com.rynkowsw.model.Punkt2d;
import com.rynkowsw.model.Punkt3d;
import com.rynkowsw.model.Vector2d;
import com.rynkowsw.model.Vector3d;
import java.util.ArrayList;

/**
 *
 * @author WR
 */
public interface OperationInterface extends ProjectionInterface {

    public ArrayList<Vector3d> makeOperation(ArrayList<Vector3d> vectors);

    public default ArrayList<Vector2d> makeOperationAndProjection(ArrayList<Vector3d> vectors, Camera camera) {
        return makeProjection(makeOperation(vectors), camera);

    }

}
