package Model;

public class Quarto {
	private int codigo;
	private int numero;
	private int capacidade;
	private double valorDiaria;
	private boolean status;
	
	public Quarto() {}
	
	public Quarto(int codigo, int numero, int capacidade, double valorDiaria) {
		this.codigo = codigo;
		this.numero = numero;
		this.capacidade = capacidade;
		this.status = true;
		this.valorDiaria = valorDiaria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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


}
