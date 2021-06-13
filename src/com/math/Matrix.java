package com.math;

import com.util.MathException;

public class Matrix {
	public final int m;
	public final int n;
	public double mat[][];

	public Matrix(int m, int n) {
		this.m = m;
		this.n = n;
		this.mat = new double[this.m][this.n];
	}

	public Matrix(int n) {
		this.m = this.n = n;
		this.mat = new double[this.m][this.n];

	}

	Matrix(Matrix mat) {
		this.m = mat.m;
		this.n = mat.n;
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; i++) {
				this.mat[i][j] = mat.mat[i][j];
			}
		}
	}

	public Matrix(int m, int n, double[][] mat) {
		this.m = m;
		this.n = n;
		this.mat = mat;
	}

	public Matrix(int n, double[][] mat) {
		this.m = this.n = n;
		this.mat = mat;
	}

	public Matrix addition(Matrix mat) throws MathException {
		if (this.m != mat.m || this.n != mat.n) {
			throw new MathException("Cant Add : Mat1.m = " + this.m + " | Mat1.n = " + this.n + " || Mat2.m = " + mat.m
					+ " | Mat2.n = " + mat.n + ".", MathException.DIMENSION_MISMATCH_EXCEPTION);
		}
		double[][] ans = new double[this.m][this.n];
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				ans[i][j] = this.mat[i][j] + mat.mat[i][j];
			}
		}
		return new Matrix(this.m, this.n, ans);

	}

	public Matrix subtraction(Matrix mat) throws MathException {
		if (this.m != mat.m || this.n != mat.n) {
			throw new MathException("Cant Subtract : Mat1.m = " + this.m + " | Mat1.n = " + this.n + " || Mat2.m = "
					+ mat.m + " | Mat2.n = " + mat.n + ".", MathException.DIMENSION_MISMATCH_EXCEPTION);
		}
		double[][] ans = new double[this.m][this.n];
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				ans[i][j] = this.mat[i][j] - mat.mat[i][j];
			}
		}
		return new Matrix(this.m, this.n, ans);

	}

	public Matrix multiplication(Matrix mat) throws MathException {
		if (this.n != mat.m) {
			throw new MathException("Cant Multiply : Mat1.n = " + this.n + " | Mat2.m = " + mat.m + ".",
					MathException.DIMENSION_MISMATCH_EXCEPTION);
		}

		double ans[][] = new double[this.m][mat.n];
		double sum = 0;
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < mat.n; j++) {
				sum = 0;
				for (int k = 0; k < this.n; k++) {
					sum += this.mat[i][k] * mat.mat[k][j];
				}
				ans[i][j] = sum;
			}
		}
		return new Matrix(this.m, mat.n, ans);
	}

	public Matrix scalar(double s) {
		double[][] mat = new double[this.m][this.n];
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				mat[i][j] = this.mat[i][j] * s;
			}
		}
		return new Matrix(this.m, this.n, mat);
	}

	public Matrix division(double d) {
		double[][] mat = new double[this.m][this.n];
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				mat[i][j] = this.mat[i][j] / d;
			}
		}
		return new Matrix(this.m, this.n, mat);
	}
//
//
//Vec3 Matrix::operator * (const Vec3 &v)const {
//    if (this.n == 3 && this.m==3) {
//        double sum = 0;
//        double* ptr = (double*)(&v);
//        double ans[3];
//        for (int i = 0; i < this.m; i++) {
//            sum = 0;
//            for (int j = 0; j < this.n; j++) {
//                sum += this.mat[i * this.n + j] * ptr[j];
//            }
//            ans[i] = sum;
//        }
//        return Vec3(ans[0], ans[1], ans[2]);
//    }
//    else {
//        //throw ChiliException(__FILE__,__LINE__,L"Dimension missmatch Performing Multipliccation With Vector !");
//    }
//}
//
//
//Matrix Matrix::operator/(double d)const
//	{
//    double* mat = new double[this.m * this.n];
//    for (int i = 0; i < this.m; i++) {
//        for (int j = 0; j < this.n; j++) {
//            mat[i * this.n + j] = this.mat[i * this.n + j] / d;
//        }
//    }
//    return Matrix(this.m, this.n, mat);
//}

	public void add(Matrix mat) throws MathException {

		if (this.m != mat.m || this.n != mat.n) {
			throw new MathException("Cant Add : Mat1.m = " + this.m + " | Mat1.n = " + this.n + " || Mat2.m = " + mat.m
					+ " | Mat2.n = " + mat.n + ".", MathException.DIMENSION_MISMATCH_EXCEPTION);
		}

		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				this.mat[i][j] += mat.mat[i][j];
			}
		}
	}

	public void subtract(Matrix mat) throws MathException {

		if (this.m != mat.m || this.n != mat.n) {
			throw new MathException("Cant Subtract : Mat1.m = " + this.m + " | Mat1.n = " + this.n + " || Mat2.m = "
					+ mat.m + " | Mat2.n = " + mat.n + ".", MathException.DIMENSION_MISMATCH_EXCEPTION);
		}

		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				this.mat[i][j] -= mat.mat[i][j];
			}
		}

	}

	public void muliply(Matrix mat) throws MathException {
		if (this.n != mat.m) {
			throw new MathException("Cant Multiply : Mat1.n = " + this.n + " | Mat2.m = " + mat.m + ".",
					MathException.DIMENSION_MISMATCH_EXCEPTION);
		}

		double ans[][] = new double[this.m][mat.n];
		double sum = 0;
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < mat.n; j++) {
				sum = 0;
				for (int k = 0; k < this.n; k++) {
					sum += this.mat[i][k] * mat.mat[k][j];
				}
				ans[i][j] = sum;
			}
		}
		this.mat = ans;
	}

	public void scal(double s) {

		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				this.mat[i][j] *= s;
			}
		}
	}

	public void divie(double d) {
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; i < this.n; j++) {
				this.mat[i][j] /= d;
			}
		}
	}

	public double get(int i, int j) {

		return this.mat[i][j];
	}

	public void set(double s, int i, int j) {
		this.mat[i][j] = s;
	}

	public int getRowCount() {
		return this.m;
	}

	public int getColCount() {
		return this.n;
	}

	public static Matrix rotation3DX(double theta) {

		double sinTheta = Math.sin(theta);
		double cosTheta = Math.cos(theta);
		double[][] mat = new double[3][3];
		mat[0][0] = 1;
		mat[0][1] = 0;
		mat[0][2] = 0;

		mat[1][0] = 0;
		mat[1][1] = cosTheta;
		mat[1][2] = -sinTheta;

		mat[2][0] = 0;
		mat[2][1] = sinTheta;
		mat[2][2] = cosTheta;

		return new Matrix(3, 3, mat);
	}

	public static Matrix rotation3DY(double theta) {
		double sinTheta = Math.sin(theta);
		double cosTheta = Math.cos(theta);
		double[][] mat = new double[3][3];

		mat[0][0] = cosTheta;
		mat[0][1] = 0;
		mat[0][2] = sinTheta;

		mat[1][0] = 0;
		mat[1][1] = 1;
		mat[1][2] = 0;

		mat[2][0] = -sinTheta;
		mat[2][1] = 0;
		mat[2][2] = cosTheta;

		return new Matrix(3, 3, mat);
	}

	public static Matrix rotation3DZ(double theta) {
		double sinTheta = Math.sin(theta);
		double cosTheta = Math.cos(theta);
		double[][] mat = new double[3][3];

		mat[0][0] = cosTheta;
		mat[0][1] = -sinTheta;
		mat[0][2] = 0;

		mat[1][0] = sinTheta;
		mat[1][1] = cosTheta;
		mat[1][2] = 0;

		mat[2][0] = 0;
		mat[2][1] = 0;
		mat[2][2] = 1;

		return new Matrix(3, 3, mat);
	}
	
	
	@Override 
	public String toString() {
		String s="[\n";
		for (int i=0;i<this.m;i++) {
			s+="[ ";
			for(int j=0;j<this.n;j++) {
				s+=this.mat[i][j]+"\t";
			}
			s+="]\n";
		}
		s+="]";
		
		return s;
	}
}