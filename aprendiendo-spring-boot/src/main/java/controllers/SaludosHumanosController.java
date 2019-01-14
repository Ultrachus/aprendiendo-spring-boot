package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.impl.BusinessService;

@RestController
public class SaludosHumanosController {

	// Puedo definir el valor de un atributo en cualquier clase recogiendo el valor
	// desde el application, yml o properties
	@Value("${proyecto.titulo}")
	private String titulo;

	private static final String SALTO_DE_LINEA_BR = "<br>";

	// Si marco el atributo como final ya no puedo inicializarlo con un autowired en
	// la declaración del atributo, entonces debo usar el autowired en el
	// constructor de la clase que recibe los bean para inicializar los atributos de
	// la clase
	private final BusinessService businessService;

	@Autowired
	public SaludosHumanosController(BusinessService businessService) {
		this.businessService = businessService;
	}

	@RequestMapping("/saludos")
	public String saludos() {

		StringBuilder sb = new StringBuilder();
		sb.append(titulo);
		sb.append(SALTO_DE_LINEA_BR);
		sb.append("este título viene del controlador");
		sb.append(SALTO_DE_LINEA_BR);
		sb.append(SALTO_DE_LINEA_BR);
		sb.append(businessService.getTituloService());

		return sb.toString();
	}

}
