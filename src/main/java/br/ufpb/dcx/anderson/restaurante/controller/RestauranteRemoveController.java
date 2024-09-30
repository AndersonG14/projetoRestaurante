package br.ufpb.dcx.anderson.restaurante.controller;

import br.ufpb.dcx.anderson.restaurante.Restaurante;
import br.ufpb.dcx.anderson.restaurante.PedidoNaoEncontradoException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestauranteRemoveController implements ActionListener {
    private Restaurante restaurante;
    private JFrame janelaPrincipal;

    public RestauranteRemoveController(Restaurante restaurante, JFrame janela) {
        this.restaurante = restaurante;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Coleta o ID do pedido a ser removido
            int idPedido = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Digite o ID do pedido a ser removido:"));

            // Tenta remover o pedido
            restaurante.removerPedido(idPedido);

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(janelaPrincipal, "Pedido #" + idPedido + " removido com sucesso.");
        } catch (PedidoNaoEncontradoException ex) {
            // Mensagem de erro caso o pedido não seja encontrado
            JOptionPane.showMessageDialog(janelaPrincipal, "Erro: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            // Mensagem de erro caso o ID fornecido não seja um número válido
            JOptionPane.showMessageDialog(janelaPrincipal, "ID inválido. Por favor, digite um número.");
        }
    }
}
