package bd2.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;

import bd2.Muber.dto.PasajeroCreditoDto;
import bd2.Muber.dto.TravelCalificacionDto;
import bd2.Muber.dto.TravelPassengerDto;
import bd2.Muber.dto.driver.DriverDTO;
import bd2.Muber.dto.passenger.PassengerDTO;
import bd2.Muber.dto.travel.TravelDTO;
import bd2.Muber.services.impl.ServiceLocator;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class MuberRestController {

	@Autowired
	private ServiceLocator serviceLocator;

	/*
	 * 
	 * Listar todos los pasajeros registrados en Muber
	 * http://localhost:8080/MuberRESTful/rest/services/pasajeros Metodo: GET
	 * Este servicio no requiere parametros.
	 *
	 * curl -X GET http://localhost:8080/MuberRESTful/rest/services/pasajeros
	 * 
	 */
	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> listAllPassengers() {
		Map<String, Object> aMap = new HashMap<String, Object>();

		Collection<PassengerDTO> passengers = serviceLocator.getPassengerService().getPassengers();

		if (passengers.isEmpty()) {
			aMap.put("result", "No Content");
			return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.NO_CONTENT);
		}
		aMap.put("result", "OK");
		aMap.put("resultingObjects", passengers);
		return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.OK);
	}

	/*
	 * Listar todos los conductores registrados en Muber
	 * http://localhost:8080/MuberRESTful/rest/services/conductores Metodo: GET
	 * Este servicio no requiere parametros
	 * 
	 * curl -X GET http://localhost:8080/MuberRESTful/rest/services/conductores
	 */

	@RequestMapping(value = "/conductores", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> conductoresList() {
		Map<String, Object> aMap = new HashMap<String, Object>();

		Collection<DriverDTO> drivers = serviceLocator.getDriverService().getDrivers();
		if (drivers.isEmpty()) {
			aMap.put("result", "No Content");
			return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.NO_CONTENT);
		}
		aMap.put("result", "OK");
		aMap.put("resultingObjects", drivers);
		return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.OK);
	}

	/*
	 * Listar todos los viajes abiertos en Muber
	 * http://localhost:8080/MuberRESTful/rest/services/viajes/abiertos Metodo:
	 * GET Este servicio no requiere parametros
	 * 
	 * curl -X GET
	 * http://localhost:8080/MuberRESTful/rest/services/viajes/abiertos
	 * 
	 */
	@RequestMapping(value = "/viajes/abiertos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> abiertosList() {
		Map<String, Object> aMap = new HashMap<String, Object>();

		Collection<TravelDTO> travelsOpen = serviceLocator.getTravelService().getTravelsOpen();
		if (travelsOpen.isEmpty()) {
			aMap.put("result", "No Content");
			return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.NO_CONTENT);
		}
		aMap.put("result", "OK");
		aMap.put("resultingObjects", travelsOpen);
		return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.OK);
	}

	/*
	 * Obtener la informacion de un conductor (nombre de usuario, viajes
	 * realizados, puntaje promedio y fecha de licencia)
	 * http://localhost:8080/MuberRESTful/rest/services/conductores/detalle?
	 * conductorId=1 Metodo: GET Este servicio recibe un parametro: conductorId
	 * 
	 * curl -X GET
	 * http://localhost:8080/MuberRESTful/rest/services/conductores/detalle/1
	 *
	 */

	@RequestMapping(value = "/conductores/detalle", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> driverDetail(long conductorId) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		DriverDTO driver = serviceLocator.getDriverService().getDriverById(conductorId);
		if (driver == null) {
			aMap.put("result", "No Content");
			return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.NO_CONTENT);
		}
		aMap.put("result", "OK");
		aMap.put("resultingObjects", driver);
		return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.OK);
	}

	/*
	 * Listar los 10 conductores mejor calificados que no tengan viajes abiertos
	 * registrados
	 * http://localhost:8080/MuberRESTful/rest/services/conductores/top10
	 * Metodo: GET Este servicio no requiere parametros
	 * 
	 * curl -X GET
	 * http://localhost:8080/MuberRESTful/rest/services/conductores/top10
	 *
	 */
	@RequestMapping(value = "/conductores/top10", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<String> driversTop10() {
		Map<String, Object> aMap = new HashMap<String, Object>();

		Collection<DriverDTO> drivers = serviceLocator.getDriverService().getTopTenDrivers();
		if (drivers != null && !drivers.isEmpty()) {
			aMap.put("result", "OK");
			aMap.put("resultingObjects", drivers);
			return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.OK);
		}
		aMap.put("result", "No Content");
		return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.NO_CONTENT);

	}

	/*
	 * 
	 * Crear un viaje
	 * http://localhost:8080/MuberRESTful/rest/services/viajes/nuevo Metodo:
	 * POST Este servicio recibe los siguientes parametros: origen, destino,
	 * conductorId, costoTotal, cantidadPasajeros
	 * 
	 * PostMan
	 *
	 * { "origen":"Origen", "destino":"Destino", "conductorId": 1, "costoTotal":
	 * 123.45, "cantidadPasajeros": 4 }
	 *
	 */
	@RequestMapping(value = "/viajes/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<String> newTravel(@RequestBody TravelDTO travel) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		long lastId = serviceLocator.getTravelService().saveTravel(travel);
		if (lastId == 0) {
			aMap.put("result", "Conflict");
			return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.CONFLICT);
		}
		aMap.put("result", lastId);
		return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.CREATED);
	}

	/*
	 * Crear una calificacion de un pasajero para un viaje en particular
	 * http://localhost:8080/MuberRESTful/rest/services/viajes/calificar Metodo:
	 * POST Este servicio recibe los siguientes parametros: viajeId, pasajeroId,
	 * puntaje, comentario
	 * 
	 * PostMan
	 * 
	 * { "viajeId":1, "pasajeroId":3, "puntaje": 1, "comentario": "OKEY" }
	 *
	 */
	@RequestMapping(value = "/viajes/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<String> newRating(@RequestBody TravelCalificacionDto travelCalificacion) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		long lastId = serviceLocator.getTravelService().rateTravel(travelCalificacion.getViajeId(),
				travelCalificacion.getPasajeroId(), travelCalificacion.getPuntaje(),
				travelCalificacion.getComentario());

		if (lastId == 0) {
			aMap.put("result", "Conflict");
			return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.CONFLICT);
		}

		aMap.put("result", lastId);
		return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.CREATED);
	}

	/*
	 * Crear un pasajero nuevo
	 * http://localhost:8080/MuberRESTful/rest/services/pasajeros/nuevo Metodo:
	 * POST Este servicio recibe los siguientes parametros: name, password,
	 * credit
	 * 
	 * PostMan
	 * 
	 * { "name":"name", "password":"password", "credit": 2300 }
	 *
	 */

	@RequestMapping(value = "/pasajeros/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<String> newPassenger(@RequestBody PassengerDTO passenger) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		long lastId = serviceLocator.getPassengerService().savePassenger(passenger);
		if (lastId == 0) {
			aMap.put("result", "Conflict");
			return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.CONFLICT);
		}

		aMap.put("result", lastId);
		return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.CREATED);
	}

	/*
	 * 
	 * Agregar un pasajero a un viaje ya creado
	 * http://localhost:8080/MuberRESTful/rest/services/viajes/agregarPasajero
	 * Metodo: PUT Este servicio recibe los siguientes parametros: viajeId,
	 * pasajeroId
	 *
	 * PostMan
	 * 
	 * { "viajeId":2, "pasajeroId":5 }
	 *
	 */

	@RequestMapping(value = "/viajes/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<String> addPassengerToTravel(@RequestBody TravelPassengerDto travelPassenger) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		if (serviceLocator.getTravelService().updateTravel(travelPassenger.getViajeId(),
				travelPassenger.getPasajeroId()) == 0) {
			aMap.put("result", "Conflict");
			return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.CONFLICT);
		}

		aMap.put("result", "OK");
		return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.OK);
	}

	/*
	 * Cargar credito a un pasajero en particular
	 * http://localhost:8080/MuberRESTful/rest/services/pasajeros/cargarCredito
	 * Metodo: PUT Este servicio recibe los siguientes parametros: pasajeroId,
	 * monto
	 * 
	 * PostMan
	 * 
	 * { "pasajeroId":5, "monto":123.45 }
	 * 
	 */

	@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<String> chargeCredit(@RequestBody PasajeroCreditoDto pasajeroCredito) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		if (serviceLocator.getPassengerService().updatePassenger(pasajeroCredito.getPasajeroId(),
				pasajeroCredito.getMonto()) == 0) {
			aMap.put("result", "Conflict");
			return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.CONFLICT);
		}

		aMap.put("result", "OK");
		return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.OK);
	}

	/*
	 * Finalizar un viaje. Considerar que el viaje solo puede finalizarse una
	 * vez. http://localhost:8080/MuberRESTful/rest/services/viajes/finalizar
	 * Metodo: PUT Este servicio recibe los siguientes parametros: viajeId
	 * 
	 * PostMan
	 * 
	 * { "viajeId":2 }
	 */

	@RequestMapping(value = "/viajes/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<String> closetravel(@RequestBody TravelDTO travelDto) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		if (serviceLocator.getTravelService().closeTravel(travelDto.getViajeId()) == 0) {
			aMap.put("result", "Conflict");
			return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.CONFLICT);
		}

		aMap.put("result", "OK");
		return new ResponseEntity<String>(new Gson().toJson(aMap), HttpStatus.OK);
	}

	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

}
