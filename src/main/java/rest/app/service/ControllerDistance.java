package rest.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rest.app.Distance;
import rest.app.Location;

@RestController
public class ControllerDistance {

	private final static double EARTH_RADIUS = 6371; // radius in kilometers
	@Autowired
	private LocationRepository locationRepository;
	

	private double calculateDistance(double latitude, double longitude, double latitude2, double longitude2) 
	{
		double lon1Radians = Math.toRadians(longitude);
		double lon2Radians = Math.toRadians(longitude2);
		double lat1Radians = Math.toRadians(latitude);
		double lat2Radians = Math.toRadians(latitude2);
		double a = haversine(lat1Radians, lat2Radians) + Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return (EARTH_RADIUS * c);
	}

	private double haversine(double deg1, double deg2) {
		return square(Math.sin((deg1 - deg2) / 2.0));
	}

	private double square(double x) {
		return x * x;
	}


	@RequestMapping(value="/distance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Distance getLocation(@RequestParam(name="postcode1", required=false)  String postcode1,	
								@RequestParam(name="postcode2", required=false)  String postcode2) {

		Location location1 = locationRepository.findByPostcode(postcode1);	
		Location location2 = locationRepository.findByPostcode(postcode2);
		
		double calcDistance = calculateDistance(location1.getLatitude(), location1.getLongitude(), location2.getLatitude(), location2.getLongitude()); 
		Distance distance = new Distance(location1, location2, calcDistance); 
		return distance;

	}
	
	

}
