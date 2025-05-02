package com.bank.coin.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "api")
public class ApiData {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String updated;
    private String updatedIso;
    private String updateduk;
    private String chartName;
    private String disclaimer;

    @OneToMany(mappedBy = "api", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CurrencyData> currencies;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getUpdatedIso() {
		return updatedIso;
	}

	public void setUpdatedIso(String updatedIso) {
		this.updatedIso = updatedIso;
	}

	public String getUpdateduk() {
		return updateduk;
	}

	public void setUpdateduk(String updateduk) {
		this.updateduk = updateduk;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public List<CurrencyData> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<CurrencyData> currencies) {
		this.currencies = currencies;
	}

	@Override
	public String toString() {
		return "ApiData [Id=" + Id + ", updated=" + updated + ", updatedIso=" + updatedIso + ", updateduk=" + updateduk
				+ ", chartName=" + chartName + ", disclaimer=" + disclaimer + ", currencies=" + currencies + "]";
	}
    
}
