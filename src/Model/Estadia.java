package Model;

import java.util.Date;

public class Estadia {
	private int codigo;
	private Quarto quarto;
	private int quantidadeHospedes;
	private Cliente cliente;
	private Date dataEntrada;
	private Date dataSaida;
	private int quantidadeDiarias;
	
	public Estadia(int codigo, Quarto quarto, int quantidadeHospedes, Cliente cliente, Date dataEntrada, Date dataSaida, int quantidadeDiarias) {
		this.codigo = codigo;
		this.quarto = quarto;
		this.quantidadeHospedes = quantidadeHospedes;
		this.cliente = cliente;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.quantidadeDiarias = quantidadeDiarias;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public int getQuantidadeHospedes() {
		return quantidadeHospedes;
	}
	public void setQuantidadeHospedes(int quantidadeHospedes) {
		this.quantidadeHospedes = quantidadeHospedes;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public int getQuantidadeDiarias() {
		return quantidadeDiarias;
	}
	public void setQuantidadeDiarias(int quantidadeDiarias) {
		this.quantidadeDiarias = quantidadeDiarias;
	}
}
