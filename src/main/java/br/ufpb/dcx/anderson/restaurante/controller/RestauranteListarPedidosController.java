package br.ufpb.dcx.anderson.restaurante.controller;

import br.ufpb.dcx.anderson.restaurante.Pedido;
import br.ufpb.dcx.anderson.restaurante.Restaurante;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class RestauranteListarPedidosController implements ActionListener {
    private Restaurante restaurante;
    private JFrame janelaPrincipal;
    private JTable tabelaPedidos;
    private DefaultTableModel modeloTabela;

    public RestauranteListarPedidosController(Restaurante restaurante, JFrame janela, JTable tabelaPedidos, DefaultTableModel modeloTabela) {
        this.restaurante = restaurante;
        this.janelaPrincipal = janela;
        this.tabelaPedidos = tabelaPedidos;
        this.modeloTabela = modeloTabela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Limpa a tabela antes de listar os pedidos
        modeloTabela.setRowCount(0);

        // Itera sobre os pedidos e adiciona cada um à tabela
        for (Pedido pedido : restaurante.getPedidos().values()) {
            modeloTabela.addRow(new Object[]{
                    pedido.getIdPedido(),
                    pedido.getMesa(),
                    String.join(", ", pedido.getItens()),
                    pedido.getStatus()
            });
        }

        // Mostra uma mensagem informando que os pedidos foram listados
        JOptionPane.showMessageDialog(janelaPrincipal, "Pedidos listados com sucesso.");
    }
}
