package Util;

/**
 * Classe de utilidades diversas
 *
 * @author Sarah Júlia
 */
public class Utilities {

    /**
     * metodo que verifica se a string passada é um numero inteiro
     *
     * @param s String a ser testada
     * @return
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * metodo que verifica se a string passada é um numero do tipo double
     *
     * @param s String a ser testada
     * @return
     */
    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
