package Util;

/**
 * Classe para objeto de resposta com status e mensagem
 *
 * @author Sarah Júlia
 */
public class ResponseMessage {

    public boolean status;
    public String mensagem;

    /**
     * contrutor padrao de objeto vazio
     */
    public ResponseMessage() {
    }

    /**
     * contrutor para criação de objeto com os dados
     * @param status boolean
     * @param mensagem String
     */
    public ResponseMessage(boolean status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }
}
