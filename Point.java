/**
 * Represents 2 dimensional points.
 * Maman12 question1 2019a
 * Maytal Twig
 * @version 17/11/18
 */
public class Point {
private double _radius;
private double _alpha;
private final double DEFAULT_VAL=0.0;
private final double TO_DEGREES=180/Math.PI;
private final double TO_RADIANS=(Math.PI/180);

/**
 * Constructor for objects of class Point.
 * Construct a new point with the specified x y coordinates. If the x coordinate is negative it is set to zero. If the y coordinate is negative it is set to zero.
 * @param x - The x coordinate
 * @param y - The y coordinate
 */
public Point(double x, double y) {
	if(x<=DEFAULT_VAL) 
		x=DEFAULT_VAL;//Reset x if negative
	if(y<=DEFAULT_VAL) 
		y=DEFAULT_VAL;//Reset y if negative
	_radius=Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));//Convert values
	_alpha=Math.atan(y/x)*TO_DEGREES;//Convert values
}

/**
Constructor for objects of class Point.
Copy constructor, construct a point using another point.
 * @param other - The point from which to construct the new object
  */
public Point(Point other)
{
	double x=other.getX();
	double y=other.getY();
	_radius=Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	_alpha=Math.atan(y/x)*TO_DEGREES;
}



/**
 *Check the distance between this point and a given point.
 * @param other - The point to check the distance from
 * @return The distance
 * 
 */
public double distance (Point p)
{
	return Math.sqrt(Math.pow(p.getY()-getY(), 2)+Math.pow(p.getX()-getX(), 2));
}

/**
 * Check if the given point is equal to this point.
 * @param other - The point to check equality with
 * @return True if the given point is equal to this point
 */
public boolean equals(Point other)
{
	if(this.getX()==other.getX()&&this.getY()==other.getY())
		return true;
	else
		return false;
}

/**
 * This method returns the x coordinate of the point.
 * @return The x coordinate of the point
 */
public double getX()
{
	return Math.round((this._radius)*(Math.cos(this._alpha*TO_RADIANS)*10000))/(double)10000;//Rounding the resulting value
}

/**
 * This method returns the y coordinate of the point.
 * @return The y coordinate of the point
 */
public double getY()
{
	return Math.round((this._radius)*(Math.sin(this._alpha*TO_RADIANS)*10000))/(double)10000;//Rounding the resulting value
}

/**
 * Check if this point is above a received point.
 * @param other - The point to check if this point is above
 * @return True if this point is above the other point
 */
public boolean isAbove(Point other) {
	return (getY()>other.getY());
}

/**
 * Check if this point is left of a received point.
 * @param other - The point to check if this point is left of
 * @return true if this point is to the left of other point 
 */
public boolean isLeft(Point other) {
	return (getX()<other.getX());
}
/**
 * Check if this point is right of a received point.
 * @param other - The point to check if this point is right of
 * @return True if this point is right of the other point
 *  */
public boolean isRight(Point other) {
	return other.isLeft(this);//verify whether the point is to the left according to both methods

}

/**
 * Check if this point is below a received point.
 * @param other - The point to check if this point is below
 * @return True if this point is below the other point
 *  */
public boolean isUnder(Point other) {
	return other.isAbove(this);//verify whether the point is above according to both methods
}
/**
 * Moves a point.
 * If either coordinate becomes negative the point remains unchanged.
 * @param dx - The difference to add to x
 * @param dy - The difference to add to y
  */
public void move(double dX, double dY) {
	if((getX()+dX)>=DEFAULT_VAL&&(getY()+dY)>=DEFAULT_VAL){
		double x=getX(),y=getY();
		setX(x+dX);
		setY(y+dY);
}
}

/**
 * This method sets the x coordinate of the point.
 * If the new x coordinate is negative the old x coordinate
 * will remain unchanged.
 * @param x - The new x coordinate
 */
public void setX(double x)
{
	if (x>=DEFAULT_VAL) {
		double other_y=getY();//
		_radius=Math.sqrt(Math.pow(x, 2)+Math.pow(other_y, 2));
		_alpha=Math.atan(other_y/x)*TO_DEGREES;
	}
}
/** 
 * This method sets the y coordinate of the point.
 * If the new y coordinate is negative the old y coordinate
 * will remain unchanged.
 * @param y - The new y coordinate
 */
public void setY(double y)
{
	if (y>=DEFAULT_VAL) {//
		double other_x=getX();
		_radius=Math.sqrt((Math.pow(other_x, 2))+(Math.pow(y, 2)));
		_alpha=Math.atan(y/other_x)*TO_DEGREES;
	}
	}
/**
 * Returns a string representation of Point in the format(x,y).
 * @return A String representation of the Point
 */
public String toString()
{
	return "("+getX()+","+getY()+")";
}
}