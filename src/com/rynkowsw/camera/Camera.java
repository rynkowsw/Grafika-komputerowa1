package com.rynkowsw.camera;

import com.rynkowsw.model.Punkt3d;
import com.rynkowsw.paint.Utils;


public class Camera {
	// od rzutni do srodka rzutowania  ~ ogniskowa
	private double rzutnia;
	// rzutnia px
	private final int height = Utils.HEIGHT;
	private final int width = Utils.WIDTH;
	private double yCamera; // polozenie kamery

	public Camera(double vpd, int rz_height, int rz_width, double y) {
		rzutnia = vpd;
		yCamera = y; // 0 jak w slajdach
	}
        public Camera() {
		rzutnia = 500.0;
		yCamera = 0; // 0 jak w slajdach
	}
	public void zoomIn() {
		rzutnia += Utils.ZOOM_STEP;
	}

	public void zoomOut() {
		rzutnia = rzutnia - Utils.ZOOM_STEP;
	}

	public boolean isVisible(Punkt3d point) {
		if (point.getY() >= yCamera + rzutnia) {	//yc = 0
			//przed rzutnia
			return true;
		} else {
			return false;
		}
	}

	public void setVPD(double d) {
		if (d < 0) {
			System.err.println("Odleglosc rzutni nie moze byc mniejsza niz 0 !");
		}

		this.rzutnia = d;

	}

	public double getVPD() {
		return this.rzutnia;
	}

	public int getRzutniaHeight() {
		return this.height;
	}

	public int getRzutniaWidth() {
		return this.width;
	}

	public double getYCamera() {
		return yCamera;
	}

	public void setYCamera(double aY) {
		this.yCamera = aY;
	}
}