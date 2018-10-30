package rest.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Location")
public class Location{
	
	@Id
	private int id;
	@Column(name="longitude")
	private double longitude;
	@Column(name="latitude")
	private double latitude;
	@Column(name="postcode")
	private String postcode;
	
	public Location() {
	}
	
	public Location(int id, double longitude, double latitude, String postcode) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.postcode = postcode;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	

}
