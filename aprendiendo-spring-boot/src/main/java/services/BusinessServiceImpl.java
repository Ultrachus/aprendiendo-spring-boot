package services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import services.impl.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Value("${proyecto.tituloService}")
	private String tituloService;

	@Override
	public String getTituloService() {
		StringBuilder sb = new StringBuilder();
		sb.append(tituloService);
		sb.append("<br>");
		sb.append("este título viene del servicio");

		return sb.toString();
	}
}
