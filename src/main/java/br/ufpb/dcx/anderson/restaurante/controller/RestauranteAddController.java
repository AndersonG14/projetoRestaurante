package br.ufpb.dcx.anderson.restaurante.controller;

import br.ufpb.dcx.anderson.restaurante.Restaurante;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RestauranteAddController implements ActionListener {
    private Restaurante restaurante;
    private JFrame janelaPrincipal;

    public RestauranteAddController(Restaurante restaurante, JFrame janela) {
        this.restaurante = restaurante;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Coleta as informações do pedido usando janelas de diálogo
        String mesa = JOptionPane.showInputDialog(janelaPrincipal, "Qual é o número da mesa?");
        String itensStr = JOptionPane.showInputDialog(janelaPrincipal, "Quais são os itens (separados por vírgula)?");
        String status = JOptionPane.showInputDialog(janelaPrincipal, "Qual é o status do pedido?");

        // Converte a string de itens em uma lista
        List<String> itens = new ArrayList<>();
        for (String item : itensStr.split(",")) {
            itens.add(item.trim());
        }

        // Adiciona o pedido ao restaurante
        restaurante.adicionarPedido(mesa, itens, status);

        // Exibe uma mensagem confirmando a adição do pedido
        JOptionPane.showMessageDialog(janelaPrincipal, "Pedido adicionado com sucesso!");
    }
}