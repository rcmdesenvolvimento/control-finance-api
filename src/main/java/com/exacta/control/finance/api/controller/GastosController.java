package com.exacta.control.finance.api.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exacta.control.finance.api.dtos.GastoDto;
import com.exacta.control.finance.api.service.GastosService;

@RestController
@RequestMapping("api/gastos")
public class GastosController {

	private final GastosService gastoService;

	public GastosController(GastosService gastoService) {
		this.gastoService = gastoService;
	}

	@GetMapping
	public ResponseEntity<List<GastoDto>> findAll() {
		List<GastoDto> list = gastoService.findAll().stream().map(obj -> new GastoDto(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{idGasto}")
	public ResponseEntity<GastoDto> findById(@PathVariable long idGasto) {
		try {
			GastoDto obj = new GastoDto(gastoService.findById(idGasto));
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping
	public ResponseEntity<GastoDto> create(@Valid @RequestBody GastoDto obj) {
		obj = new GastoDto(gastoService.create(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGasto())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public ResponseEntity<GastoDto> update(@Valid @RequestBody GastoDto obj) {
		obj = new GastoDto(gastoService.update(obj));
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping
	public void deleteById(@Valid @RequestBody GastoDto obj) {
		this.gastoService.deleteById(obj);
	}

}
