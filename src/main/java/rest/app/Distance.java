package rest.app;

public class Distance {
	
	private Location location1;
	private Location location2;
	private final String unit = "km";
	private double distance;
	
	public Distance() {
		super();
		this.location1 = new Location();
		this.location2 = new Location();
		this.distance = 0;
	}
	
	public Distance(Location location1, Location location2, double distance) {
		super();
		this.location1 = location1;
		this.location2 = location2;
		this.distance = distance;
	}

	public Location getLocation1() {
		return location1;
	}

	public void setLocation1(Location location1) {
		this.location1 = location1;
	}

	public Location getLocation2() {
		return location2;
	}

	public void setLocation2(Location location2) {
		this.location2 = location2;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getUnit() {
		return unit;
	}
	
	

}
