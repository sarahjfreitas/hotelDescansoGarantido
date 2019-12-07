package Model;

import java.util.Date;

/**
 * Classe para objetos do tipo Estadia
 *
 * @author Sarah Júlia
 */
public class Estadia {

    private int codigo;
    private Quarto quarto;
    private int quantidadeHospedes;
    private Cliente cliente;
    private Date dataEntrada;
    private Date dataSaida;
    private int quantidadeDiarias;

    /**
     * Contrutor para criação da estadia com os dados
     *
     * @param codigo int - codigo da estadia
     * @param quarto Quarto - quarto vinculado
     * @param quantidadeHospedes int - quantidade de hospedes
     * @param cliente Cliente - cliente vinculado
     * @param dataEntrada Date - data de entrada do hospede
     * @param dataSaida Date - data de saida do hospede
     * @param quantidadeDiarias - int quantidade de diarias
     */
    public Estadia(int codigo, Quarto quarto, int quantidadeHospedes, Cliente cliente, Date dataEntrada, Date dataSaida, int quantidadeDiarias) {
        this.codigo = codigo;
        this.quarto = quarto;
        this.quantidadeHospedes = quantidadeHospedes;
        this.cliente = cliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quantidadeDiarias = quantidadeDiarias;
    }

    /**
     * Método que calcula o custo total da estadia
     *
     * @return Double valor total da estadia
     */
    public double getValorTotal() {
        return (quarto.getValorDiaria() * quantidadeDiarias);
    }

    /**
     * Método que retorna o codigo da estadia
     *
     * @return int - codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método que define o codigo da estadia
     *
     * @param codigo - int codigo da estadia
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que retorna o quarto vinculado com a estadia
     *
     * @return Quarto - quarto vinculado
     */
    public Quarto getQuarto() {
        return quarto;
    }

    /**
     * Método que define o quarto vinculado com a estadia
     *
     * @param quarto Quarto - quarto vinculado
     */
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    /**
     * Método que retorna a quantidade de hospedes
     *
     * @return int quantidade de hospedes
     */
    public int getQuantidadeHospedes() {
        return quantidadeHospedes;
    }

    /**
     * Método que define o quarto vinculado com a estadia
     *
     * @param quantidadeHospedes int - quantidade de hospedes
     */
    public void setQuantidadeHospedes(int quantidadeHospedes) {
        this.quantidadeHospedes = quantidadeHospedes;
    }

    /**
     * Método que retorna o cliente hosperado
     *
     * @return Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método que define o cliente hosperado
     *
     * @param cliente Cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Método que retorna a data de entrada do cliente
     *
     * @return Data data de entrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * Método que define a data de entrada do cliente
     *
     * @param dataEntrada Data
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * Método que retorna a data de saida do cliente
     *
     * @return Data data de saida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * Método que define a data de saida do cliente
     *
     * @param dataSaida Data
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * Método que retorna a quantiade de diarias
     *
     * @return int quantidade de diarias
     */
    public int getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    /**
     * Método que define a quantiade de diarias
     *
     * @param quantidadeDiarias int
     */
    public void setQuantidadeDiarias(int quantidadeDiarias) {
        this.quantidadeDiarias = quantidadeDiarias;
    }
}
