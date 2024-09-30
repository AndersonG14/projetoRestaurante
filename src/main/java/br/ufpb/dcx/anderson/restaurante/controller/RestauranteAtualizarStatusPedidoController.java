package br.ufpb.dcx.anderson.restaurante.controller;
import br.ufpb.dcx.anderson.restaurante.Restaurante;
import br.ufpb.dcx.anderson.restaurante.PedidoNaoEncontradoException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestauranteAtualizarStatusPedidoController implements ActionListener {
    private Restaurante restaurante;
    private JFrame janelaPrincipal;

    public RestauranteAtualizarStatusPedidoController(Restaurante restaurante, JFrame janela) {
        this.restaurante = restaurante;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Coleta o ID do pedido a ser atualizado
            int idPedido = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Digite o ID do pedido para atualizar:"));

            // Coleta o novo status
            String novoStatus = JOptionPane.showInputDialog(janelaPrincipal, "Digite o novo status do pedido:");

            // Tenta atualizar o status do pedido
            restaurante.atualizarStatusPedido(idPedido, novoStatus);

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(janelaPrincipal, "Status do Pedido #" + idPedido + " atualizado para: " + novoStatus);
        } catch (PedidoNaoEncontradoException ex) {
            // Mensagem de erro caso o pedido não seja encontrado
            JOptionPane.showMessageDialog(janelaPrincipal, "Erro: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            // Mensagem de erro caso o ID fornecido não seja um número válido
            JOptionPane.showMessageDialog(janelaPrincipal, "ID inválido. Por favor, digite um número.");
        }
    }
}
