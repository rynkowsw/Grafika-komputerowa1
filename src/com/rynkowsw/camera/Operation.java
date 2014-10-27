
package com.rynkowsw.camera;
import com.rynkowsw.model.Punkt2d;
import com.rynkowsw.model.Punkt3d;
import com.rynkowsw.model.Vector2d;
import com.rynkowsw.model.Vector3d;
import com.rynkowsw.paint.Utils;
import java.util.ArrayList;

/**
 *
 * @author WR
 */
public class Operation{
    private ArrayList<Vector3d> vectors = new ArrayList<>();
	private Camera camera;
	private int xd = Utils.WIDTH / 2;
	private int zd = Utils.HEIGHT / 2;

	public Operation(ArrayList<Vector3d> aVectors, Camera aCamera) {
		vectors = aVectors;
		camera = aCamera;
	}

	// actions
	public void zoomIn() {
		camera.zoomIn();
	}

	public void zoomOut() {
		camera.zoomOut();
	}

	public void moveForward() {

		for (Vector3d it : vectors) {
			it.getA().setY(it.getA().getY() - Utils.TRANSLATION_STEP);
			it.getB().setY(it.getB().getY() - Utils.TRANSLATION_STEP);
		}
	}

	public void moveBackward() {
		for (Vector3d it : vectors) {
			it.getA().setY(it.getA().getY() + Utils.TRANSLATION_STEP);
			it.getB().setY(it.getB().getY() + Utils.TRANSLATION_STEP);
		}
	}

	public void moveLeft() {
		for (Vector3d it : vectors) {
			it.getA().setX(it.getA().getX() + Utils.TRANSLATION_STEP);
			it.getB().setX(it.getB().getX() + Utils.TRANSLATION_STEP);
		}
	}

	public void moveRight() {
		for (Vector3d it : vectors) {
			it.getA().setX(it.getA().getX() - Utils.TRANSLATION_STEP);
			it.getB().setX(it.getB().getX() - Utils.TRANSLATION_STEP);
		}
	}

	public void moveUp() {
		for (Vector3d it : vectors) {
			it.getA().setZ(it.getA().getZ() - Utils.TRANSLATION_STEP);
			it.getB().setZ(it.getB().getZ() - Utils.TRANSLATION_STEP);
		}
	}

	public void moveDown() {
		for (Vector3d it : vectors) {
			it.getA().setZ(it.getA().getZ() + Utils.TRANSLATION_STEP);
			it.getB().setZ(it.getB().getZ() + Utils.TRANSLATION_STEP);
		}
	}

	public void rotateUp() {
		double ay, az, by, bz;

		for (Vector3d it : vectors) {

			ay = it.getA().getY();
			az = it.getA().getZ();
			by = it.getB().getY();
			bz = it.getB().getZ();

			it.getA().setY((ay * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)) - (az * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)));
			it.getA().setZ((ay * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)) + (az * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)));

			it.getB().setY((by * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)) - (bz * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)));
			it.getB().setZ((by * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)) + (bz * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)));

		}

	}

	public void rotateDown() {
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

	}

	public void rotateRight() {
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
	}

	public void rotateLeft() {
		double ax, ay, bx, by;
		for (Vector3d it : vectors) {
			ax = it.getA().getX();
			ay = it.getA().getY();
			bx = it.getB().getX();
			by = it.getB().getY();

			it.getA().setX((ax * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)) - (ay * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)));
			it.getA().setY((ax * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)) + (ay * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)));

			it.getB().setX((bx * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)) - (by * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)));
			it.getB().setY((bx * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)) + (by * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)));
		}

	}

	public void rotateRightLean() {
		double ax, az, bx, bz;
		for (Vector3d it : vectors) {
			ax = it.getA().getX();
			az = it.getA().getZ();
			bx = it.getB().getX();
			bz = it.getB().getZ();

			it.getA().setX((ax * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)) + (az * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)));
			it.getA().setZ(((-1) * ax * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)) + (az * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)));

			it.getB().setX((bx * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)) + (bz * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)));
			it.getB().setZ(((-1) * bx * java.lang.Math.sin((-1) * Utils.ROTATE_STEP)) + (bz * java.lang.Math.cos((-1) * Utils.ROTATE_STEP)));
		}

	}

	public void rotateLeftLean() {
		double ax, az, bx, bz;
		for (Vector3d it : vectors) {
			ax = it.getA().getX();
			az = it.getA().getZ();
			bx = it.getB().getX();
			bz = it.getB().getZ();

			it.getA().setX((ax * java.lang.Math.cos(Utils.ROTATE_STEP)) + (az * java.lang.Math.sin(Utils.ROTATE_STEP)));
			it.getA().setZ(((-1) * ax * java.lang.Math.sin(Utils.ROTATE_STEP)) + (az * java.lang.Math.cos(Utils.ROTATE_STEP)));

			it.getB().setX((bx * java.lang.Math.cos(Utils.ROTATE_STEP)) + (bz * java.lang.Math.sin(Utils.ROTATE_STEP)));
			it.getB().setZ(((-1) * bx * java.lang.Math.sin(Utils.ROTATE_STEP)) + (bz * java.lang.Math.cos(Utils.ROTATE_STEP)));
		}
	}

	/* rzutowanie */

	public ArrayList<Vector2d> makeProjection() {
		// zrzutowany caly widok na 2D
		ArrayList<Vector2d> projection = new ArrayList<Vector2d>();
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

	@SuppressWarnings("unchecked")
	protected ArrayList<Vector3d> getLines() {
		return (ArrayList<Vector3d>) vectors.clone();
	}

	private Vector2d makeProjection(Punkt3d p1, Punkt3d p2) {
		return new Vector2d(projectPoint(p1), projectPoint(p2));
	}

	private Punkt2d projectPoint(Punkt3d point) {
		double wsp = camera.getVPD() / (point.getY() - camera.getYCamera());
		int x = (int) (wsp * point.getX() + xd);
		int z = (int) (zd - wsp * point.getZ());
		return new Punkt2d(x, z);
	}

	protected double getCameraY() {
		return this.camera.getYCamera();
	}

	/* graficzne */

	

	/* settery/gettery */
	public ArrayList<Vector3d> getVectors() {
		return vectors;
	}

	public void setVectors(ArrayList<Vector3d> vectors) {
		this.vectors = vectors;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public int getXd() {
		return xd;
	}

	public void setXd(int xd) {
		this.xd = xd;
	}

	public int getZd() {
		return zd;
	}

	public void setZd(int zd) {
		this.zd = zd;
	}
       public void printVectors(){
          ArrayList<Vector3d> vectors = this.getVectors();
           for(Vector3d it: vectors)
			System.out.println(it.getA()+ "  ;  " + it.getB() );
	}
	
}
