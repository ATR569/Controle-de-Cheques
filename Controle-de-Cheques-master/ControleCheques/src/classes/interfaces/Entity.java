/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.interfaces;

/**
 *
 * @author Adson Macêdo
 */
public interface Entity {
    public abstract String getFields();
    public abstract String getValues();
    public abstract String getKeyField();
    public abstract int getKeyValue();
    public abstract void setKeyValue(int value);
}
