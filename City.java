/**
 * Represents information about a city Maman12 question2 2019a
 * @author Maytal Twig
 *version 18/11/18
 */
public class City {
	private String _cityName;
	private Point _cityCenter;
	private Point _centralStation;
	private long _numOfResidents;
	private int _noOfNeighborhoods;
	public final int MIN_NEIGBORHOODS=1;
	public final long MIN_RESIDENTS=0;
/**
 * Constructor for objects of class City.
 * @param other
 */
	public City(City other) {
		this._cityName=other._cityName;
		this._cityCenter=new Point(other._cityCenter);
		this._centralStation=new Point(other._centralStation);
		this._numOfResidents=other._numOfResidents;
		this._noOfNeighborhoods=other._noOfNeighborhoods;
	}
/**
 * Constructor for objects of class City.
 */
	public City (String cityName, double cityCenterX, double cityCenterY, double centralStationX, double centralStationY,long numOfResidents, int noOfNeighborhoods) {
		_cityName=cityName;
		_cityCenter=new Point(cityCenterX,cityCenterY);
		_centralStation=new Point(centralStationX,centralStationY) ;
		_numOfResidents=numOfResidents;
		_noOfNeighborhoods=noOfNeighborhoods;
		if(numOfResidents<MIN_RESIDENTS) 
			_numOfResidents=MIN_RESIDENTS;
		if(noOfNeighborhoods<=MIN_NEIGBORHOODS)
			_noOfNeighborhoods=MIN_NEIGBORHOODS; 
	}
 
 /**Adds the given number of residents either positive or negative number - to the city.
  * @param residentsUpdate
  * @return false if the Number Of Residents is less than minimum
  * @return true and the total
  */
 public boolean addResidents(long residentsUpdate) {
	 if (getNumOfResidents()+residentsUpdate<MIN_RESIDENTS) {
		 setNumOfResidents(MIN_RESIDENTS);//if smaller than minimum - Reset.
		 return false;
	 }
	 setNumOfResidents(getNumOfResidents()+residentsUpdate);
	 return true;
	 
 }
 /**
  * Calculates the distance between the center of this city and its central station.
  * @return the distance.
  */
 public double distanceBetweenCenterAndStation()  {
	 return _centralStation.distance(_cityCenter);
 }
/**
 * Returns the central station of the city as a Point object.
 */
 public Point getCentralStation() {
	 return _centralStation;
 }
 /**
  * Returns the center of the city as a Point object.
  */
 public Point getCityCenter() {
	 return _cityCenter;
 }
 /**
  * Returns the name of the city.
    */
 public String getCityName(){
	 return _cityName;
 }
/**
 * Returns the number of neighborhoods of the city.
 */
 public int getNoOfNeighborhoods() {
	 return (_noOfNeighborhoods);
 }
 /**
  * Returns the number of residents of the city.
  */
 public long getNumOfResidents() {
	 return (_numOfResidents);
 }
 /**
  * Move the location of the central station of the city with the given deltas.
  * @param deltaX
  * @param deltaY
  */
public void moveCentralStation(double deltaX, double deltaY){
	_centralStation.move(deltaX, deltaY);
}
 /**
  * Creates a new city with a new name, and where its center and central station are moved by the given deltas from this city.
  * @param newCityName
  * @param dX
  * @param dY
  * @return new city
  */
public City newCity(String newCityName, double dX, double dY) {
	City c=new City(this);
	c.moveCentralStation(dX, dY);
	c.getCityCenter().move(dX, dY);
	c.setCityName(newCityName);
	c.setNoOfNeighborhoods(MIN_NEIGBORHOODS);
	c.setNumOfResidents(MIN_RESIDENTS);
	return c;
}	
/**
 * Sets the central station point of the city.
 * @param centralStation
 */
public void setCentralStation(Point centralStation) {
	_centralStation=new Point(centralStation);
}

/**
 * Sets the center point of the city.
 * @param cityCenter
 */
public void setCityCenter(Point cityCenter) {
	_cityCenter=new Point(cityCenter);
}
/**
 * Sets the name of the city.
 * @param cityName
 */
public void setCityName(String cityName) {
	_cityName=cityName;
}
/**
 * Sets the number of neighborhoods of the city, but only if it is bigger than MIN_NEIGBORHOODS
 * @param noOfNeighborhoods
 * @return the number of neighborhoods if bigger than the minimum
 */
public void setNoOfNeighborhoods(int noOfNeighborhoods) {
	if (noOfNeighborhoods<MIN_NEIGBORHOODS) {
		_noOfNeighborhoods=MIN_NEIGBORHOODS;
		return;
	}
	_noOfNeighborhoods=noOfNeighborhoods;
	
}
/**
 * Sets the number of residents of the city, but only if it is bigger than MIN_RESIDENTS
 * @param numOfResidents
 * @return the number of residents if bigger than the minimum
 */
public void setNumOfResidents(long numOfResidents) {
	if (numOfResidents<MIN_RESIDENTS) {
		_numOfResidents=MIN_RESIDENTS;
		return;
	}
	_numOfResidents=numOfResidents;
}
/**
 * Returns a string representation of this City in the format
 *City Name: Tel Aviv
 *City Center: (5.0,8.0)
 *Central Station: (3.0,4.0)
 *NumOfResidents: 1004
 *No Of Neighborhoods: 5
 */
public String toString() {
	return ("City Name: "+getCityName()+"\n"+"City Center: "+getCityCenter()+"\n"+"Central Station: "+getCentralStation()+"\n"+"NumOfResidents: "+getNumOfResidents()+"\n"+"No Of Neighborhoods: "+getNoOfNeighborhoods());
}
}