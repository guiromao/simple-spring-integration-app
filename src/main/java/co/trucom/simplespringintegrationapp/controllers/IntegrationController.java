package co.trucom.simplespringintegrationapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.trucom.simplespringintegrationapp.gateway.IntegrationGateway;

@RestController
@RequestMapping("/api/v1/integration")
public class IntegrationController {

	private IntegrationGateway integrationGateway;

	public IntegrationController(IntegrationGateway gateway) {
		integrationGateway = gateway;
	}

	@GetMapping("/{name}")
	public ResponseEntity<Map<String, String>> sayHi(@PathVariable String name) {
		Map<String, String> response = new HashMap<>();
		response.put("message", integrationGateway.sendMessage(name));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
