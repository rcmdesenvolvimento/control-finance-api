package com.exacta.control.finance.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exacta.control.finance.api.model.Gasto;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {

}
