package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import constants.Constants;
import services.impl.BusinessService;

@RestController
public class SaludosHumanosController {

	// Puedo definir el valor de un atributo en cualquier clase recogiendo el valor
	// desde el application, yml o properties
	@Value("${proyecto.titulo}")
	private String titulo;

	// Si marco el atributo como final ya no puedo inicializarlo con un autowired en
	// la declaración del atributo, entonces debo usar el autowired en el
	// constructor de la clase que recibe los bean para inicializar los atributos de
	// la clase
	private final BusinessService businessService;

	private String textoRecogido = "No se ha recibido texto";

	@Autowired
	public SaludosHumanosController(BusinessService businessService) {
		this.businessService = businessService;
	}

	@GetMapping(path = "/saludos")
	public String saludos() {

		StringBuilder sb = new StringBuilder();
		sb.append(titulo);
		sb.append(Constants.SALTO_DE_LINEA);
		sb.append("este título viene del controlador");
		sb.append(Constants.SALTO_DE_LINEA);
		sb.append(Constants.SALTO_DE_LINEA);
		sb.append(businessService.getTituloService());
		sb.append(Constants.SALTO_DE_LINEA);
		sb.append(Constants.SALTO_DE_LINEA);
		sb.append("Recogí este texto de una llamada put: ");
		sb.append(textoRecogido);

		return sb.toString();
	}

	@PutMapping(path = "/recogerTexto/{texto}")
	public void recogerTexto(@PathVariable String texto) {
		textoRecogido = texto;
	}

}
