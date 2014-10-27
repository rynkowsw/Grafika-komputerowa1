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
public interface ProjectionInterface {

    public int xd = Utils.WIDTH / 2;
    public int zd = Utils.HEIGHT / 2;

    public default ArrayList<Vector2d> makeProjection(ArrayList<Vector3d> vectors, Camera camera) {
        ArrayList<Vector2d> projection;
        projection = new ArrayList<Vector2d>();
        Punkt3d p1, p2;
        Vector2d vector2d;

        for (Vector3d it : vectors) {
            p1 = it.getA();
            p2 = it.getB();

            if (camera.isVisible(p1) && camera.isVisible(p2)) {
                vector2d = makeProjection(p1, p2);
                projection.add(vector2d);
            }
        }

        return projection;
    }

    public default Vector2d makeProjection(Punkt3d p1, Punkt3d p2) {
        return new Vector2d(projectPoint(p1), projectPoint(p2));
    }

    public default Punkt2d projectPoint(Punkt3d point) {
        Camera camera = new Camera();
        double wsp = camera.getVPD() / (point.getY() - camera.getYCamera());
        int x = (int) (wsp * point.getX() + xd);
        int z = (int) (zd - wsp * point.getZ());
        return new Punkt2d(x, z);
    }
}
