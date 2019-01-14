package controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludosHumanosController {

	@Value("${proyecto.titulo}")
	private String titulo;

	@RequestMapping("/saludos")
	public String saludos() {

		StringBuilder sb = new StringBuilder();
		sb.append(titulo);
		sb.append('\r');
		sb.append('\n');
		sb.append("Saludos desde Spring Boot");

		return sb.toString();
	}

}
