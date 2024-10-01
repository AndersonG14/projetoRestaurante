package br.ufpb.dcx.anderson.restaurante.controller;

import br.ufpb.dcx.anderson.restaurante.Restaurante;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RestauranteAddController implements ActionListener {
    private Restaurante restaurante;
    private JTextField txtMesa;
    private JTextField txtItens;
    private JTextField txtStatus;
    private JTextArea outputArea;
    private JTable tabelaPedidos;

    public RestauranteAddController(Restaurante restaurante, JTextField txtMesa, JTextField txtItens, JTextField txtStatus, JTextArea outputArea, JTable tabelaPedidos) {
        this.restaurante = restaurante;
        this.txtMesa = txtMesa;
        this.txtItens = txtItens;
        this.txtStatus = txtStatus;
        this.outputArea = outputArea;
        this.tabelaPedidos = tabelaPedidos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String mesa = txtMesa.getText();
        String itensStr = txtItens.getText();
        String status = txtStatus.getText();
        List<String> itens = new ArrayList<>();

        for (String item : itensStr.split(",")) {
            itens.add(item.trim());
        }

        restaurante.adicionarPedido(mesa, itens, status);
        outputArea.append("Pedido adicionado: Mesa " + mesa + ", Itens: " + itens + ", Status: " + status + "\n");

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