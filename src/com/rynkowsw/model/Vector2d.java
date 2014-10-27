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
public class Vector2d{
    public Vector2d(Punkt2d a, Punkt2d b) {
    this.a=a;
    this.b=b;
}
    private Punkt2d a;
    private Punkt2d b;

    public Punkt2d getA() {
        return a;
    }

    public void setA(Punkt2d a) {
        this.a = a;
    }

    public Punkt2d getB() {
        return b;
    }

    public void setB(Punkt2d b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "krawedz2d{" + "a=" + a + ", b=" + b + '}';
    }
    private static final Logger LOG = Logger.getLogger(Vector2d.class.getName());
    
}
