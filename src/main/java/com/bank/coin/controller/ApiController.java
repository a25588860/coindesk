package com.bank.coin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.coin.model.ApiData;
import com.bank.coin.model.NotFoundException;
import com.bank.coin.service.ApiService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping
    public List<ApiData> getAll() {
        return apiService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiData> getById(@PathVariable Long id) {
        ApiData data = apiService.getById(id)
                .orElseThrow(() -> new NotFoundException("資料不存在"));
        return ResponseEntity.ok(data);
    }
    
//    拋出錯誤404 一般寫法無法自訂錯誤訊息
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiData> getById(@PathVariable Long id) {
//        return apiService.getById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @PostMapping
    public ApiData create(@RequestBody ApiData apiData) {
        return apiService.create(apiData);
    }

    @PutMapping("/{id}")
    public ApiData update(@PathVariable Long id, @RequestBody ApiData apiData) {
        return apiService.update(id, apiData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        apiService.delete(id);
    }

}
