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
    public static String quotedStr(String str){
        return "\"" + str + "\"";
    }
    
    public static double toDouble(String val){
        return Double.parseDouble(val.replaceAll("[^0-9,]", "").replaceAll(",", "."));
    }
    
}
