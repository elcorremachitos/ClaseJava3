package Ejercicio3;

import javax.swing.*;

public class Window {
    private final String appName;

    public Window(String appName) {
        this.appName = appName;
    }

    public void showMessageWindow(String text){
        JOptionPane.showMessageDialog(null,text,appName,JOptionPane.PLAIN_MESSAGE);
    }

    public String showInputWindow(String text){
        return JOptionPane.showInputDialog(null,text,appName,JOptionPane.PLAIN_MESSAGE);
    }

    public int showOptionWindow(String text, String[] list){
        return JOptionPane.showOptionDialog(null,text,appName,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null,list,list[0]);
    }
}
