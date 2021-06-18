/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.math;

import com.util.MathException;

/**
 *
 * @author Akshay
 */
public class Vec3 {

	public double x, y, z;
	public double r;

	public Vec3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.r = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	public void add(Vec3 v) {
		this.x += v.x;
		this.y += v.y;
		this.z += v.z;
		this.r = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);

	}

	public void subtract(Vec3 v) {
		this.x -= v.x;
		this.y -= v.y;
		this.z -= v.z;
		this.r = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	public Vec3 addition(Vec3 v) {
		return new Vec3(this.x + v.x, this.y + v.y, this.z + v.z);
	}

	public Vec3 subtraction(Vec3 v) {
		return new Vec3(this.x - v.x, this.y - v.y, this.z - v.z);
	}

	public void negate() {
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;
	}

	public Vec3 crossProd(Vec3 v) {
		return new Vec3(this.y * v.z - this.z * v.y, this.z * v.x - this.x - v.z, this.x * v.y - this.y * v.x);
	}

	public double dotProd(Vec3 v) {
		return this.x * v.x + this.y * v.y + this.z * v.z;
	}

	public void scal(double s) {
		this.x *= s;
		this.y *= s;
		this.z *= s;
		this.r *= Math.abs(s);
	}

	public void scal(double s, Vec3 v) {
		this.subtract(v);
		this.x *= s;
		this.y *= s;
		this.z *= s;
		this.r *= Math.abs(s);
		this.add(v);
	}

	public Vec3 scalar(double s) {
		return new Vec3(this.x * s, this.y * s, this.z * s);

	}

	public void multiply(Matrix mat) throws MathException {
		if (mat.m == 3 && mat.n == 3) {

			double ans[] = new double[3];
			for (int i = 0; i < 3; i++) {
				ans[i] = mat.mat[i][0] * this.x + mat.mat[i][1] * this.y + mat.mat[i][2] * this.z;
			}
			this.setXYZ(ans[0], ans[1], ans[2]);
		} else {
			throw new MathException("cannot multiply with Vec3 : Mat.m = " + mat.m + " | Mat.n = " + mat.n + ".",
					MathException.DIMENSION_MISMATCH_EXCEPTION);
		}
	}

	Vec3 multiplication(Matrix mat) throws MathException {
		if (mat.m == 3 && mat.n == 3) {
			double[] ans = new double[3];
			for (int i = 0; i < 3; i++) {

				ans[i] = mat.mat[i][0] * this.x + mat.mat[i][1] * this.y + mat.mat[i][2] * this.z;
			}
			return new Vec3(ans[0], ans[1], ans[2]);
		} else {
			throw new MathException("cannot multiply with Vec3 : Mat.m = " + mat.m + " | Mat.n = " + mat.n + ".",
					MathException.DIMENSION_MISMATCH_EXCEPTION);
		}
	}

	public Vec3 getUnit() {
		return scalar(1 / this.r);
	}
	
	
	public Vec3 proj(Vec3 v) {
		Vec3 u=v.getUnit();
		u.scal(this.dotProd(v)/v.r);
		return u;
		
	}
	public void makeUnit() {
		this.scal(1/this.r);
	}

	public void rotateX(double theta) throws MathException {
		Matrix rotMat = Matrix.rotation3DX(theta);
		this.multiply(rotMat);

	}

	public void rotateY(double theta) throws MathException {
		Matrix rotMat = Matrix.rotation3DY(theta);
		this.multiply(rotMat);
	}

	public void rotateZ(double theta) throws MathException {
		Matrix rotMat = Matrix.rotation3DZ(theta);
		this.multiply(rotMat);
	}

	public void rotateX(double theta, Vec3 v) throws MathException {
		this.subtract(v);
		Matrix rotMat = Matrix.rotation3DX(theta);
		this.multiply(rotMat);
		this.add(v);
	}

	public void rotateY(double theta, Vec3 v) throws MathException {
		this.subtract(v);
		Matrix rotMat = Matrix.rotation3DY(theta);
		this.multiply(rotMat);
		this.add(v);
	}

	public void rotateZ(double theta, Vec3 v) throws MathException {
		this.subtract(v);
		Matrix rotMat = Matrix.rotation3DZ(theta);
		this.multiply(rotMat);
		this.add(v);
	}

	public void setXYZ(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.r = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}
	
        @Override
	public String toString() {
		return "("+this.x+", "+this.y+", "+this.z+")";
	}
}
