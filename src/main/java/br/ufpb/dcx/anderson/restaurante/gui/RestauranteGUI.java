package br.ufpb.dcx.anderson.restaurante.gui;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class RestauranteGUI extends JFrame {
    public RestauranteGUI(){
        setTitle("Restaurante de Anderson");
        setSize(600,600);
        setLocation(0, 0);
        //localização da janela na tela
        setResizable(false);
        //janela não redimensionável
        getContentPane().setBackground(Color.lightGray);
    }
    //...

    public static void main(String [] args){
        RestauranteGUI janela = new RestauranteGUI();
        janela.setVisible(true);
        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e){

                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanelaPrincipal);

    }

}



