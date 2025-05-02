package com.bank.coin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.coin.model.ApiData;

public interface ApiRepository extends JpaRepository<ApiData, Long> {

}
