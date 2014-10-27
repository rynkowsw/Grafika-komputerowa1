/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rynkowsw.model;

/**
 *
 * @author WR
 */
public class Punkt2d {

    public Punkt2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private double x;
    private double y;

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
