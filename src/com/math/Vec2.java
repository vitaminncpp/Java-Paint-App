package com.math;
//
///**
// *
// * @author Akshay
// */
//public class Vec2 {
//
//    double x;
//    double y;
//    private double r, theta;
//
//    public Vec2(double x, double y) {
//        this.x = x;
//        this.y = y;
//        setRT();
//    }
//
//    public Vec2(double r, double theta, boolean f) {
//        this.r = r;
//        this.theta = theta;
//        setXY();
//    }
//
//    private void setRT() {
//
//    }
//
//    private void setXY() {
//
//    }
//
//    public void setXY(double x, double y) {
//        this.x = x;
//        this.y = y;
//        setRT();
//    }
//
//    public void setRT(double r, double theta) {
//        this.r = r;
//        this.theta = theta;
//        setXY();
//    }
//
//    public double getX() {
//        return this.x;
//    }
//
//    public double getY() {
//        return this.y;
//    }
//
//    public double getR() {
//        return this.r;
//    }
//
//    public double getT() {
//        return this.theta;
////    }
////
////    public static Vec2 addition(Vec2 u, Vec2 v) {
////        return new Vec2(u.x + v.x, u.y + v.y);
////    }
////
////    public static Vec2 subtraction(Vec2 u, Vec2 v) {
////        return new Vec2(u.x - v.x, u.y - v.y);
//    }
//
//    public void add(Vec2 u) {
//        this.x += u.x;
//        this.y += u.y;
//        setRT();
//    }
//
//    public void sub(Vec2 u) {
//        this.x -= u.x;
//        this.y -= u.y;
//        setRT();
//    }
//
//    public Vec2 addition(Vec2 u) {
//        return new Vec2(this.x + u.x, this.y + u.y);
//    }
//
//    public Vec2 proj(Vec2 u) {
//        return null;
//    }
//
//    public void rotate(double theta) {
//        this.theta += theta;
//        setXY();
//    }
//
//    public Vec2 rotation(double theta) {
//        return new Vec2(this.r, this.theta + theta, true);
//    }
//
//    public void scal(double s) {
//        this.r *= s;
//        this.x *= s;
//        this.y *= s;
//    }
//
//    public Vec2 scalar(double s) {
//        return new Vec2(this.x * s, this.y * s);
//    }
//
//    public Vec2 unit() {
//        return null;
//    }
//}
//
//

/**
 * @author Akshay
 */
public class Vec2 {

    private double x;
    private double y;
    private double r;
    private double theta;

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
        this.AdjustRT();
    }


    public Vec2(double r, double theta, boolean f) {
        this.r = r;
        this.theta = theta;
        this.AdjustXY();
    }

    public void add(Vec2 v) {
        this.x += v.x;
        this.y += v.y;
        AdjustRT();

    }

    public void sub(Vec2 v) {
        this.x -= v.x;
        this.y -= v.y;
        AdjustRT();
    }

    public void scal(double k) {
        this.x *= k;
        this.y *= k;
        this.r *= k;
    }

    public void scal(double s, Vec2 v) {
        this.sub(v);
        this.scal(s);
        this.add(v);
    }

    public Vec2 addition(Vec2 v) {
        return new Vec2(this.x + v.x, this.y + v.y);
    }

    public Vec2 subtraction(Vec2 v) {
        return new Vec2(this.x - v.x, this.y - v.y);
    }

    public Vec2 projection(Vec2 v) {
        return null;
    }

    public Vec2 scalar(double k) {
        return new Vec2(this.x * k, this.y * k);
    }

    public void rotate(double theta) {
        this.theta = Common.wrapAngle(this.theta + theta);
        AdjustXY();
    }

    public void rotate(double theta, Vec2 v) {
        this.sub(v);
        this.rotate(theta);
        this.add(v);

    }

    public Vec2 rotation(double theta) {
        return new Vec2(this.r, Common.wrapAngle(this.theta + theta), true);
    }

    public Vec2 getUnit() {
        return this.scalar(1 / this.r);
    }

    public double dotProd(Vec2 v) {
        return this.x * v.x + this.y * v.y;
    }

    //
//            
//    public static Vec2 addition(Vec2 v1, Vec2 v2){
//        return new Vec2 ( v1 . x + v2 . x , v1 . y + v2 . y ) ;
//    }
//    
//    public static Vec2 subtraction ( Vec2 v1 , Vec2 v2 ) {
//        return new Vec2 ( v1 . x - v2 . x , v1 . y  - v2 . y ) ; 
//    }
//    public static double dot(Vec2 v1,Vec2 v2){
//        return v1 . x * v2 . x + v1 . y * v2 . y;
//    }    
//    
//    public static double angle(Vec2 v1,Vec2 v2){
//        return Math . acos ( dot ( v1 , v2 ) / ( v1 . r * v2 . r ) ) ;
//    }
    private void AdjustXY() {
        this.x = this.r * Math.cos(this.theta);
        this.y = this.r * Math.sin(this.theta);

    }

    private void AdjustRT() {
        this.r = Math.sqrt(x * x + y * y);
        this.theta = Math.abs(Math.atan(y / x));

        if (x < 0 && y < 0) {
            this.theta += Math.PI;
        } else if (x > 0 && y < 0) {
            this.theta = 2 * Math.PI - theta;
        } else if (x > 0 && y < 0) {
            this.theta = Math.PI - theta;
        }
    }

    public Vec2 getCopy() {
        return new Vec2(this.x, this.y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        this.AdjustRT();
    }

    public double getY() {
        return y;

    }

    public void setY(double y) {
        this.y = y;
        this.AdjustRT();
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
        this.AdjustRT();
    }

    public double getR() {
        return this.r;
    }

    public void setR(double r) {
        this.r = r;
        this.AdjustXY();
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = Common.wrapAngle(theta);
        this.AdjustXY();
    }

    public void setRT(double r, double theta) {
        this.r = r;
        this.theta = Common.wrapAngle(theta);

        this.AdjustXY();
    }

}
