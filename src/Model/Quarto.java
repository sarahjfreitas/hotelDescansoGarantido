package Model;

import java.util.ArrayList;
import java.util.Date;

public class Quarto {
	private int numero;
	private int capacidade;
	private double valorDiaria;
	private boolean status;
	private ArrayList<Estadia> estadias;
	
	public Quarto() {}
	
	public Quarto(int numero, int capacidade, double valorDiaria) {
		this.numero = numero;
		this.capacidade = capacidade;
		this.status = true;
		this.valorDiaria = valorDiaria;
		setEstadias(new ArrayList<Estadia>());
	}
	
	public boolean isDisponivel(Date dataEntrada, Date dataSaida) {
		for (Estadia estadia : getEstadias()) {
			if( dataEntrada.getTime() >= estadia.getDataEntrada().getTime() && dataEntrada.getTime() <= estadia.getDataSaida().getTime() ) {
				return false;
			}
			if( dataSaida.getTime() >= estadia.getDataEntrada().getTime() && dataSaida.getTime() <= estadia.getDataSaida().getTime() ) {
				return false;
			}
	    }
		return true;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public boolean isOcupado() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getStatus() {
		if(this.status) {
			return "Ocupado";
		}
		else {
			return "Disponível";
		}
	}

	public ArrayList<Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(ArrayList<Estadia> estadias) {
		this.estadias = estadias;
	}

}
