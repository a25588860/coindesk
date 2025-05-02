package com.bank.coin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.coin.model.CurrencyData;

public interface CurrencyRepository extends JpaRepository<CurrencyData, String> {

}
