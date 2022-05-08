package com.exacta.control.finance.api.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exacta.control.finance.api.dtos.GastoDto;
import com.exacta.control.finance.api.model.Gasto;
import com.exacta.control.finance.api.model.enums.Tags;
import com.exacta.control.finance.api.repository.GastoRepository;

@Service
public class GastosService {

	@Autowired
	private GastoRepository gastoRepository;

	public Gasto findById(Long id) {
		Optional<Gasto> gasto = gastoRepository.findById(id);
		return gasto.orElseThrow(
				() -> new ObjectNotFoundException("Gasto não encontrado. Código: " + id, Gasto.class.getName()));
	}

	public List<Gasto> findAll() {
		return gastoRepository.findAll();
	}

	public Gasto create(@Valid GastoDto obj) {
		return fromDTO(obj);
	}

	public Gasto update(@Valid GastoDto obj) {
		findById(obj.getIdGasto());
		return fromDTO(obj);
	}

	public void deleteById(@Valid GastoDto obj) {
		Gasto gasto = findById(obj.getIdGasto());
		gastoRepository.delete(gasto);
	}

	private Gasto fromDTO(GastoDto obj) {
		Gasto newGasto = new Gasto();
		newGasto.setIdGasto(obj.getIdGasto());
		newGasto.setNome(obj.getNome());
		newGasto.setDescricao(obj.getDescricao());
		newGasto.setValor(obj.getValor());
		newGasto.setTags(Tags.toEnum(obj.getTags().getCod()));
		return gastoRepository.save(newGasto);
	}

}
