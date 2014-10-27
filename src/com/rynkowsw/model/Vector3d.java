/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rynkowsw.model;

import java.util.logging.Logger;

/**
 *
 * @author WR
 */
public class Vector3d {
    public Vector3d(Punkt3d a, Punkt3d b) {
    this.a=a;
    this.b=b;
}
    private Punkt3d a;
    private Punkt3d b;
    private Punkt3d z;

    public Punkt3d getA() {
        return a;
    }

    public Punkt3d getB() {
        return b;
    }

    public Punkt3d getZ() {
        return z;
    }

    public void setA(Punkt3d a) {
        this.a = a;
    }

    public void setB(Punkt3d b) {
        this.b = b;
    }

    public void setZ(Punkt3d z) {
        this.z = z;
    }
    private static final Logger LOG = Logger.getLogger(Vector3d.class.getName());

    @Override
    public String toString() {
        return "Vector3d{" + "a=" + a + ", b=" + b + ", z=" + z + '}';
    }

    
    
}
