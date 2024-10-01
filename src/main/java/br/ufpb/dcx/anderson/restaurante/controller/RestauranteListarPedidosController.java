package br.ufpb.dcx.anderson.restaurante.controller;

import br.ufpb.dcx.anderson.restaurante.Restaurante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestauranteListarPedidosController implements ActionListener {
    private Restaurante restaurante;
    private JTable tabelaPedidos;

    public RestauranteListarPedidosController(Restaurante restaurante, JTable tabelaPedidos) {
        this.restaurante = restaurante;
        this.tabelaPedidos = tabelaPedidos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
