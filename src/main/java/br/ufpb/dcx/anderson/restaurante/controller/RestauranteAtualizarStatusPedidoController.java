package br.ufpb.dcx.anderson.restaurante.controller;

import br.ufpb.dcx.anderson.restaurante.PedidoNaoEncontradoException;
import br.ufpb.dcx.anderson.restaurante.Restaurante;
import br.ufpb.dcx.anderson.restaurante.Pedido;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RestauranteAtualizarStatusPedidoController implements ActionListener {
    private Restaurante restaurante;
    private JTextField txtIdPedido;
    private JTextField txtStatus;
    private JTextArea outputArea;
    private JTable tabelaPedidos;

    public RestauranteAtualizarStatusPedidoController(Restaurante restaurante, JTextField txtIdPedido, JTextField txtStatus, JTextArea outputArea, JTable tabelaPedidos) {
        this.restaurante = restaurante;
        this.txtIdPedido = txtIdPedido;
        this.txtStatus = txtStatus;
        this.outputArea = outputArea;
        this.tabelaPedidos = tabelaPedidos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int idPedido = Integer.parseInt(txtIdPedido.getText());
        String novoStatus = txtStatus.getText();
        try {
            restaurante.atualizarStatusPedido(idPedido, novoStatus);
            outputArea.append("Status do Pedido #" + idPedido + " atualizado para: " + novoStatus + "\n");
        } catch (PedidoNaoEncontradoException ex) {
            outputArea.append("Erro: " + ex.getMessage() + "\n");
        }

        // Atualiza a tabela com a nova lista de pedidos
        atualizarTabela();
    }

    private void atualizarTabela() {
        String[][] dados = obterDadosPedidos();
        String[] colunas = {"ID", "Mesa", "Itens", "Status"};

        tabelaPedidos.setModel(new DefaultTableModel(dados, colunas));
    }

    private String[][] obterDadosPedidos() {
        List<Pedido> pedidos = new ArrayList<>(restaurante.getPedidos().values());
        String[][] dados = new String[pedidos.size()][4];

        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            dados[i][0] = String.valueOf(pedido.getIdPedido());
            dados[i][1] = pedido.getMesa();
            dados[i][2] = String.join(", ", pedido.getItens());
            dados[i][3] = pedido.getStatus();
        }

        return dados;
    }
}
