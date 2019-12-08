package Model;

import java.util.ArrayList;

/**
 * Classe para objetos do tipo Cliente
 *
 * @author Sarah Júlia
 */
public class Cliente {

    private int codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private ArrayList<Estadia> estadias;

    /**
     * Contrutor para criação de cliente vazio
     */
    public Cliente() {
    }

    /**
     * Contrutor para criação de cliente com os dados
     *
     * @param codigo int - codigo do cliente
     * @param nome String - nome do cliente
     * @param endereco String - endereço do cliente
     * @param telefone String - telefone do cliente
     */
    public Cliente(int codigo, String nome, String endereco, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.estadias = new ArrayList<>();
    }

    /**
     * Método para retorno do codigo do cliente
     *
     * @return int - codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método para definir o codigo do cliente
     *
     * @param codigo int - codigo do cliente
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Método para retorno do nome do cliente
     *
     * @return nome String - nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para definir o nome do cliente
     *
     * @param nome String - nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método para retorno do endereco do cliente
     *
     * @return endereco String - endereço do cliente
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Método para definir o endereco do cliente
     *
     * @param endereco String - endereço do cliente
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Método para retornar o telefone do cliente
     *
     * @return telefone String - telefone do cliente
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Método para definir o telefone do cliente
     *
     * @param telefone String - telefone do cliente
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    /**
     * Método para retornar a lista de estadias
     *
     * @return estadias ArrayList de Estadia
     */
    public ArrayList<Estadia> getEstadias(){
        return this.estadias;
    }
    
    /**
     * Método para definir a lista de estadias
     *
     * @param estadias ArrayList de Estadia
     */
    public void setEstadias(ArrayList<Estadia> estadias){
        this.estadias = estadias;
    }   

}
