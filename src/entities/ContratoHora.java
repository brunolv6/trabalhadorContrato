package entities;

import java.util.Date;

public class ContratoHora {
	public Date data; //chamar biblioteca util.Date com ctrlshift+O
	public Double valorPorHora;
	public Integer horas;
	
	public ContratoHora(Date data, Double valorPorHora, Integer horas) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}

	//métodos
	public Double valorTotal() {
		return horas*valorPorHora;
	}
	
	//gets e sets
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
		
}
