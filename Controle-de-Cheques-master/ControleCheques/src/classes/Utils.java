/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Adson Macêdo
 */
public class Utils {
    static private Locale localeBR = new Locale("pt","BR");
    

    public static String quotedStr(String str) {
        return "\"" + str + "\"";
    }

    //criei esse método para resolver um problema dos campos formatados para cpf e outros.
    public static String toString(String str) {
        return str.replaceAll("[^0-9]","");
    }

    public static double toDouble(String val) {
        if (val == null)
            return 0;
        else{
            val = val.replaceAll("[^0-9,]", "").replace(",", ".").replaceAll(",", "");
            return val.length() == 0 ? 0 : Double.parseDouble(val);
        }
    }

    public static void main(String[] args) {
        System.out.println(toDouble("R$ 3,59"));
    }

    public static int toInt(String val) {
        if (val == null) 
            return 0;
        else{
            val = val.replaceAll("[^0-9]", "");
            return val.length() == 0 ? 0 : Integer.parseInt(val);
        }
    }
    
    public static String calendToString(Calendar cal, String format){
        if (cal == null)
            cal = Calendar.getInstance();
        return (new SimpleDateFormat(format)).format(cal.getTime());
    }

    public static String calendToString(Calendar cal){
        if (cal == null)
            cal = Calendar.getInstance();
        return (new SimpleDateFormat("dd/MM/yyyy")).format(cal.getTime());
    }
    
    public static String formatDouble(double value){
        return String.format("R$ %,.2f", value); //  Formata moeda
    }
}
