package Model;

public class Estadia {
	private int codigo;
	private Quarto quarto;
	private int quantidadeHospedes;
	private Cliente cliente;
	
	
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
}
