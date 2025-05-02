package com.bank.coin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bank.coin.model.CurrencyData;
import com.bank.coin.repository.CurrencyRepository;

@Service
public class CurrencyService {

	private CurrencyRepository currencyRepository;

	//依賴注入
	public CurrencyService(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}
	
	//搜尋全部
	public List<CurrencyData> getAll(){
		return currencyRepository.findAll();
	}
	
	//用ID搜尋
	public Optional<CurrencyData> getByCode(String code){
		return currencyRepository.findById(code);
	}
	
	//新增
	public CurrencyData create(CurrencyData currencyData) {
		return currencyRepository.save(currencyData);
	}
	
	//修改
	public CurrencyData update(String code,CurrencyData newCurrencyData) {
		Optional<CurrencyData> opCurrency = currencyRepository.findById(code);
		if(opCurrency.isPresent()) {
			CurrencyData currencyData = opCurrency.get();
			currencyData.setSymbol(newCurrencyData.getSymbol());
			currencyData.setDescription(newCurrencyData.getDescription());
			currencyData.setRate(newCurrencyData.getRate());
			currencyData.setRate_float(newCurrencyData.getRate_float());
			
			return currencyRepository.save(currencyData);
		}else {
			throw new RuntimeException("修改失敗");
		}
		
	}
	
	//刪除
	public void delete(String code) {
		Optional<CurrencyData> opCurrency = currencyRepository.findById(code);
		if(opCurrency.isPresent()) {
			currencyRepository.deleteById(code);
		}else {
			throw new RuntimeException("刪除失敗");
		}
	}
	
}
