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

	private final BusinessService businessService;

	@Autowired
	public SaludosHumanosController(BusinessService businessService) {
		this.businessService = businessService;
	}

	@RequestMapping("/saludos")
	public String saludos() {

		StringBuilder sb = new StringBuilder();
		sb.append(titulo);
		sb.append("<br>");
		sb.append("este título viene del controlador");
		sb.append("<br>");
		sb.append("<br>");
		sb.append(businessService.getTituloService());

		return sb.toString();
	}

}
