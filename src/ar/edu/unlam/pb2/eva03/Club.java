package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;

public class Club {

	private String nombre;
	private Set<Deportista> socios;
	private Map<String,Evento> competencias;
	
	
	public Club(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre=nombre;
		socios=new HashSet<Deportista>();
		competencias = new HashMap();
	}

	
	public void agregarDeportista(Deportista deportista) {
		// TODO Auto-generated method stub
		socios.add(deportista);
	}


	public Integer getCantidadSocios() {
		// TODO Auto-generated method stub
		return socios.size();
	}


	public void crearEvento(TipoDeEvento tipo, String nombre) {
		// TODO Auto-generated method stub
		competencias.put(nombre, new Evento(tipo));
	}
	
	
	public Integer inscribirEnEvento(String nombreDelEvento, Deportista deportista) throws NoEstaPreparado {
		Integer numeroDeInscripcion=0;
		Evento evento = competencias.get(nombreDelEvento);
		
		switch (evento.getTipo()) {
		
		case CARRERA_5K:
		case CARRERA_10K:
		case CARRERA_21K:
		case CARRERA_42K:
			if (deportista instanceof Corredor) {
			numeroDeInscripcion=evento.agregarParticipante(deportista);
			break;
			}	else { throw new NoEstaPreparado("No pertenece a esa categoria");}
		
		case DUATLON:
			if (deportista instanceof Ciclista) {
				numeroDeInscripcion=evento.agregarParticipante(deportista);
				break;
			}	else { throw new NoEstaPreparado("No pertenece a esa categoria");}
		
		case CARRERA_NATACION_EN_PICINA:
		case CARRERA_NATACION_EN_AGUAS_ABIERTAS:
			if (deportista instanceof Nadador) {
				numeroDeInscripcion=evento.agregarParticipante(deportista);
				break;
			}	else { throw new NoEstaPreparado("No pertenece a esa categoria");}
		
		case TRIATLON_SHORT:
		case TRIATLON_OLIMPICO:
		case TRIATLON_MEDIO:
		case TRIATLON_IRONMAN:
			if (deportista instanceof Triatleta) {
			numeroDeInscripcion=evento.agregarParticipante(deportista);
			break;
		}	else {throw new NoEstaPreparado("No pertenece a esa categoria");}
			
		default: return 0;
		}
		return null;
		
	}

}
