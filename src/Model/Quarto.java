package Model;

import java.util.ArrayList;
import java.util.Date;

public class Quarto {

    private int numero;
    private int capacidade;
    private double valorDiaria;
    private boolean status;
    private ArrayList<Estadia> estadias;

    /**
     * Contrutor para criação de quarto vazio
     */
    public Quarto() {
    }

    /**
     * Contrutor para criação de funcionario com os dados
     *
     * @param numero int - numero do quarto
     * @param capacidade int - capacidade maxima de hospedes
     * @param valorDiaria double - valor da diaria
     */
    public Quarto(int numero, int capacidade, double valorDiaria) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.status = true;
        this.valorDiaria = valorDiaria;
        this.estadias = new ArrayList<>();
    }
    
    /**
     * Método que calcula se o quarto esta disponivel no periodo passado
     *
     * @param dataEntrada Date - data de entrada desejada
     * @param dataSaida Date - data de saida desejada
     * @return boolean - retorna true se estiver disponivel e false se nao estiver
     */
    public boolean isDisponivel(Date dataEntrada, Date dataSaida) {
        for (Estadia estadia : getEstadias()) {
            if (dataEntrada.getTime() >= estadia.getDataEntrada().getTime() && dataEntrada.getTime() <= estadia.getDataSaida().getTime()) {
                return false;
            }
            if (dataSaida.getTime() >= estadia.getDataEntrada().getTime() && dataSaida.getTime() <= estadia.getDataSaida().getTime()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo para retornar o numero do quaro
     * @return int numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Metodo para definir o numero do quarto
     * @param numero int
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Metodo que retorna a capacidade maxina de hospedes do quarto
     * @return int capacidade
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Metodo que define a capacidade maxina de hospedes do quarto
     * @param capacidade int
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * Metodo que retorna o valor da diaria do quarto
     * @return double valor da diaria
     */
    public double getValorDiaria() {
        return valorDiaria;
    }

    /**
     * Metodo que define o valor da diaria do quarto
     * @param valorDiaria double
     */
    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    /**
     *  Metodo que retorna se o status de ocupacao do quarto
     * @return booelan - true quando ocupado e falso quando disponivel
     */
    public boolean isOcupado() {
        return status;
    }

    /**
     * Metodo que define se o status de ocupacao do quarto
     * @param status booelan - true quando ocupado e falso quando disponivel
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Metodo que retorna se o status de ocupacao do quarto
     * @return String Ocupado ou Disponível
     */
    public String getStatus() {
        if (this.status) {
            return "Ocupado";
        } else {
            return "Disponível";
        }
    }

    /**
     * Metodo que retorna a lista de estadias vinculadas
     * @return ArrayList de Estadia
     */
    public ArrayList<Estadia> getEstadias() {
        return estadias;
    }

    /**
     * Metodo que define a lista de estadias vinculadas
     * @param estadias ArrayList de Estadia
     */
    public void setEstadias(ArrayList<Estadia> estadias) {
        this.estadias = estadias;
    }

}
