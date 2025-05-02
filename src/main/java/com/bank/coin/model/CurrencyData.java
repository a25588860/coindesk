package com.bank.coin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="currency")
public class CurrencyData {
	
	@Id
	private String code;
    private String symbol;
    private String rate;
    private String description;
    private float rate_float;
    
    @ManyToOne
    @JoinColumn(name = "api_id", nullable = false)
    private ApiData apiData;
    
    public CurrencyData(){
    	
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRate_float() {
		return rate_float;
	}

	public void setRate_float(float rate_float) {
		this.rate_float = rate_float;
	}

	public ApiData getApiData() {
		return apiData;
	}

	public void setApiData(ApiData apiData) {
		this.apiData = apiData;
	}

	@Override
	public String toString() {
		return "CurrencyData [code=" + code + ", symbol=" + symbol + ", rate=" + rate + ", description=" + description
				+ ", rate_float=" + rate_float + ", apiData=" + apiData + "]";
	}

}
