package com.exacta.control.finance.api;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.exacta.control.finance.api.model.Gasto;
import com.exacta.control.finance.api.model.enums.Tags;
import com.exacta.control.finance.api.repository.GastoRepository;

@SpringBootApplication
public class ControlFinanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlFinanceApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(GastoRepository gastoRepository) {
		return args -> {
			gastoRepository.deleteAll(); // Limpa a base dados
			Gasto gasto = new Gasto();
			gasto.setNome("Ricardo Cardoso Miranda");
			gasto.setDescricao("Cartão de Crédito VISA");
			// gasto.setDatahora(LocalDateTime.now());
			gasto.setValor(new BigDecimal(1600.20));
			gasto.setTags(Tags.CARTAO);
			gastoRepository.save(gasto);

			// ***********************//

			Gasto gasto1 = new Gasto();
			gasto1.setNome("Rachel Camargo Miranda");
			gasto1.setDescricao("Cartão de Crédito VISA");
			// gasto1.setDatahora(LocalDateTime.now());
			gasto1.setValor(new BigDecimal(11600.20));
			gasto1.setTags(Tags.CARTAO);
			gastoRepository.save(gasto1);

			// ***********************//

			Gasto gasto2 = new Gasto();
			gasto2.setNome("Lucas Camargo Miranda");
			gasto2.setDescricao("Sindicato");
			// gasto2.setDatahora(LocalDateTime.now());
			gasto2.setValor(new BigDecimal(11600.20));
			gasto2.setTags(Tags.DINHEIRO);
			gastoRepository.save(gasto2);

			// ***********************//

			Gasto gasto3 = new Gasto();
			gasto3.setNome("Paulo Francisco Almeida");
			gasto3.setDescricao("Conta de Luz");
			// gasto3.setDatahora(LocalDateTime.now());
			gasto3.setValor(new BigDecimal(600.20));
			gasto3.setTags(Tags.DINHEIRO);
			gastoRepository.save(gasto3);
		};

	}

}
