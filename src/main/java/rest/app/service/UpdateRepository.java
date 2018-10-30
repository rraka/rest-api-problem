package rest.app.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import rest.app.Location;

public interface UpdateRepository extends CrudRepository<Location, Integer> {
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE location SET latitude = :latitude, longitude = :longitude where postcode = :postcode", nativeQuery=true) //update location long and lat by post code
	public int updateCoordinates(@Param("postcode") String postcode,
								   @Param("longitude") double longitude,
								   @Param("latitude") double latitude);		
}
