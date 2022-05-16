package br.com.buscacep.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.buscacep.model.Endereco;

@RestController
public class CepController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@GetMapping("/cep/{cep}")
	public Endereco getEnderecoPorCep(@PathVariable("cep") String cep) {
		String uri = "http://viacep.com.br/ws/" + cep + "/json/";
		RestTemplate restTemplate = new RestTemplate();
		Endereco endereco = restTemplate.getForObject(uri, Endereco.class);
		return endereco;
	}

}
