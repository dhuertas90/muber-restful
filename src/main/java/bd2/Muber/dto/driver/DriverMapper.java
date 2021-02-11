package bd2.Muber.dto.driver;

import java.util.ArrayList;
import java.util.Collection;

import bd2.Muber.model.Driver;

public class DriverMapper {
	
    public static DriverDTO mapDomainToDto(Driver domainDriver) {
        
    	DriverDTO driverDTO = new DriverDTO(domainDriver);
        return driverDTO;

    }
    
    public static Collection<DriverDTO> mapDomainToDto(Collection<Driver> driverList) {
    
		Collection<DriverDTO> drivers = new ArrayList<DriverDTO>();
		
		for (Driver p : driverList) {
			DriverDTO dr = new DriverDTO(p);
			drivers.add(dr);
		}
		return drivers;
    }
}
