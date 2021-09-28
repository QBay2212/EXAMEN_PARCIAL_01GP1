package pe.edu.upeu.parcial.Parcial.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.parcial.Parcial.modelo.Paciente;
import pe.edu.upeu.parcial.Parcial.service.PacienteService;

@RestController
@RequestMapping("/api")
public class PacienteControler {
	@Autowired
	private PacienteService pacienteService;
	
	@PostMapping("/paciente")
	public ResponseEntity<Paciente> save(@RequestBody Paciente paci){
		try {
			Paciente pa = pacienteService.create(new Paciente(paci.getIdpaciente(), 
                    paci.getDNI(), paci.getNombre(), paci.getApellido(), 
                    paci.getDireccion(),paci.getTelefono()));
			return new ResponseEntity<>(pa, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/pacientes")
	public ResponseEntity<List<Paciente>> getPaciente(){
		try {
			List<Paciente> list = new ArrayList<>();
			list = pacienteService.readAll();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/paciente/{id}")
	public ResponseEntity<Paciente> getUser(@PathVariable("id") long id){
		Paciente paciente = pacienteService.read(id);
		if (paciente.getIdpaciente()>0) {
			return new ResponseEntity<>(paciente, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("paciente/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			pacienteService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("paciente/update/{id}")
	public ResponseEntity<Paciente> update(@RequestBody Paciente paci, @PathVariable("id") long id){
		try {
			Paciente pa = pacienteService.read(id);
			if (pa.getIdpaciente()>0) {
				pa.setDNI(paci.getDNI());
                pa.setNombre(paci.getNombre());
                pa.setApellido(paci.getApellido());
                pa.setDireccion(paci.getDireccion());
                pa.setTelefono(paci.getTelefono());;
				
				return new ResponseEntity<>(pacienteService.create(pa), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
