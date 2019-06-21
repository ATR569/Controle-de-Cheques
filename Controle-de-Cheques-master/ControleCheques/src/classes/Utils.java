/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Adson Macêdo
 */
public class Utils {
    static private Locale localeBR = new Locale("pt","BR");
    static private NumberFormat curr = NumberFormat.getCurrencyInstance(localeBR); //  Formata moeda
    

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
    
    public static String calendToString(Calendar cal, String format){
        return (new SimpleDateFormat(format)).format(cal.getTime());
    }

    public static String calendToString(Calendar cal){
        return (new SimpleDateFormat("dd/MM/yyyy")).format(cal.getTime());
    }
    
    public static String formatDouble(double value){
        return curr.format(value); //  Formata moeda
    }
}
