package rest.app.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class ControllerUpdate {



	@Autowired
	private UpdateRepository updateRepository;	



	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String updateCoordinates(@RequestParam(name="postcode", required=false)  String postcode,	
			@RequestParam(name="longitude", required=false)  double longitude,
			@RequestParam(name="latitude", required=false)  double latitude) {

			updateRepository.updateCoordinates(postcode, longitude, latitude);

			
		return "Coordinates for postcode:" + postcode + " successfully updated.";

	}

}
