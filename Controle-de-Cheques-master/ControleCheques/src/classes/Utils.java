/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Adson Macêdo
 */
public class Utils {

    public static String quotedStr(String str) {
        return "\"" + str + "\"";
    }

    //criei esse método para resolver um problema dos campos formatados para cpf e outros.
    public static String toString(String str) {
        return str.replaceAll("[^0-9]","");
    }

    public static double toDouble(String val) {
        return Double.parseDouble(val.replaceAll("[^0-9,]", "").replace(",", ".").replaceAll(",", ""));
    }

    public static void main(String[] args) {
        System.out.println(toDouble("R$ 3,59"));
    }

    public static int toInt(String val) {
        return Integer.parseInt(val.replaceAll("[^0-9]", ""));
    }
}
