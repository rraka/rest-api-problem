package rest.app.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import rest.app.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {
	
	@Query(value = "SELECT * FROM location  WHERE postcode=:postcode", nativeQuery=true) //search location by post code
	public Location findByPostcode(@Param("postcode") String postcode);		
}
