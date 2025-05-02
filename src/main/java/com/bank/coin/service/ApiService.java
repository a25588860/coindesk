package com.bank.coin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bank.coin.model.ApiData;
import com.bank.coin.repository.ApiRepository;

@Service
public class ApiService {
	
	private ApiRepository apiRepository;
	
	public ApiService(ApiRepository apiRepository) {
		this.apiRepository = apiRepository;
	}
	
	//搜尋全部
	public List<ApiData> getAll(){
		return apiRepository.findAll();
	}
	
	//用ID搜尋
	public Optional<ApiData> getById(Long id){
		return apiRepository.findById(id);
	}
	
	//新增
	public ApiData create(ApiData apiData) {
		return apiRepository.save(apiData);
	}
	
	//修改  
	public ApiData update(Long id,ApiData newApiData) {
		Optional<ApiData> opApi = apiRepository.findById(id);
		//isPresent確認是否有資料
		if(opApi.isPresent()) {
			ApiData apiData = opApi.get();
			apiData.setDisclaimer(newApiData.getDisclaimer());
			apiData.setChartName(newApiData.getChartName());
			apiData.setUpdated(newApiData.getUpdated());
			apiData.setUpdatedIso(newApiData.getUpdatedIso());
			apiData.setUpdateduk(newApiData.getUpdateduk());
			
			return apiRepository.save(apiData);
			
		}else {
			throw new RuntimeException("修改失敗");
		}
		
	}
	
	//刪除
	public void delete(Long id) {
		Optional<ApiData> opApi = apiRepository.findById(id);
		if(opApi.isPresent()) {
			apiRepository.deleteById(id);
		}else {
			throw new RuntimeException("刪除失敗");
		}
		
	}
	
	

}
