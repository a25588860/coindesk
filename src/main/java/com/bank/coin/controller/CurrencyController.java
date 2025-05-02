package com.bank.coin.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.coin.model.CurrencyData;
import com.bank.coin.model.NotFoundException;
import com.bank.coin.service.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
	
	private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public List<CurrencyData> getAll() {
        return currencyService.getAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<CurrencyData> getByCode(@PathVariable String code) {
        CurrencyData data = currencyService.getByCode(code)
        		.orElseThrow(() -> new NotFoundException("資料不存在"));
        return ResponseEntity.ok(data);
    }
    
//    不使用Lambda
//    @GetMapping("/{code}")
//    public ResponseEntity<CurrencyData> getByCode(@PathVariable String code) {
//        CurrencyData data = currencyService.getByCode(code)
//                .orElseThrow(new Supplier<RuntimeException>() {
//                    @Override
//                    public RuntimeException get() {
//                        return new NotFoundException("資料不存在");
//                    }
//                });
//        return ResponseEntity.ok(data);
//    }

    @PostMapping
    public CurrencyData create(@RequestBody CurrencyData data) {
        return currencyService.create(data);
    }

    @PutMapping("/{code}")
    public CurrencyData update(@PathVariable String code, @RequestBody CurrencyData data) {
        return currencyService.update(code, data);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        currencyService.delete(code);
    }

}
