package br.ufpb.dcx.anderson.restaurante.controller;

import br.ufpb.dcx.anderson.restaurante.Restaurante;
import br.ufpb.dcx.anderson.restaurante.PedidoNaoEncontradoException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestauranteRemoveController implements ActionListener {
    private Restaurante restaurante;
    private JTextField txtIdPedido;
    private JTextArea outputArea;
    private JTable tabelaPedidos;

    public RestauranteRemoveController(Restaurante restaurante, JTextField txtIdPedido, JTextArea outputArea, JTable tabelaPedidos) {
        this.restaurante = restaurante;
        this.txtIdPedido = txtIdPedido;
        this.outputArea = outputArea;
        this.tabelaPedidos = tabelaPedidos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int idPedido = Integer.parseInt(txtIdPedido.getText());
        try {
            restaurante.removerPedido(idPedido);
            outputArea.append("Pedido #" + idPedido + " removido.\n");
        } catch (PedidoNaoEncontradoException ex) {
            outputArea.append("Erro: " + ex.getMessage() + "\n");
        }

        // Atualiza a tabela sem usar setRowCount ou addRow
        atualizarTabela();
    }

    private void atualizarTabela() {
        String[] colunas = {"ID", "Mesa", "Itens", "Status"};
        Object[][] dados = restaurante.getPedidos().values().stream()
                .map(p -> new Object[]{p.getIdPedido(), p.getMesa(), String.join(", ", p.getItens()), p.getStatus()})
                .toArray(Object[][]::new);

        tabelaPedidos.setModel(new DefaultTableModel(dados, colunas));
    }
}

