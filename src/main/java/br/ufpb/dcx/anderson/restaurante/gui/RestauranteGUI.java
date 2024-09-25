package br.ufpb.dcx.anderson.restaurante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class RestauranteGUI extends JFrame {
    private Restaurante restaurante;
    private JTextField txtMesa, txtItens, txtStatus, txtIdPedido;
    private JTextArea outputArea;
    private JTable tabelaPedidos;
    private DefaultTableModel modeloTabela;

    public RestauranteGUI() {
        restaurante = new Restaurante();

        setTitle("Gerenciamento de Pedidos - Restaurante");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para adicionar pedidos
        JPanel painelAdicao = new JPanel(new GridLayout(5, 2));
        painelAdicao.add(new JLabel("Mesa:"));
        txtMesa = new JTextField();
        painelAdicao.add(txtMesa);

        painelAdicao.add(new JLabel("Itens (separados por vírgula):"));
        txtItens = new JTextField();
        painelAdicao.add(txtItens);

        painelAdicao.add(new JLabel("Status:"));
        txtStatus = new JTextField();
        painelAdicao.add(txtStatus);

        JButton btnAdicionar = new JButton("Adicionar Pedido");
        painelAdicao.add(btnAdicionar);

        JButton btnListar = new JButton("Listar Pedidos");
        painelAdicao.add(btnListar);

        add(painelAdicao, BorderLayout.NORTH);

        // Área de texto para exibir informações
        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Tabela para mostrar os pedidos
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("Mesa");
        modeloTabela.addColumn("Itens");
        modeloTabela.addColumn("Status");

        tabelaPedidos = new JTable(modeloTabela);
        add(new JScrollPane(tabelaPedidos), BorderLayout.SOUTH);

        // Ações dos botões
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarPedido();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarPedidos();
            }
        });

        // Painel para remover ou atualizar pedidos
        JPanel painelAtualizarRemover = new JPanel(new GridLayout(3, 2));
        painelAtualizarRemover.add(new JLabel("ID do Pedido:"));
        txtIdPedido = new JTextField();
        painelAtualizarRemover.add(txtIdPedido);

        JButton btnRemover = new JButton("Remover Pedido");
        painelAtualizarRemover.add(btnRemover);

        JButton btnAtualizar = new JButton("Atualizar Status");
        painelAtualizarRemover.add(btnAtualizar);

        painelAtualizarRemover.add(new JLabel("Novo Status:"));
        txtStatus = new JTextField();
        painelAtualizarRemover.add(txtStatus);

        add(painelAtualizarRemover, BorderLayout.EAST);

        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removerPedido();
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarStatusPedido();
            }
        });

        setVisible(true);
    }

    private void adicionarPedido() {
        String mesa = txtMesa.getText();
        String itensStr = txtItens.getText();
        String status = txtStatus.getText();
        List<String> itens = new ArrayList<>();

        for (String item : itensStr.split(",")) {
            itens.add(item.trim());
        }

        restaurante.adicionarPedido(mesa, itens, status);
        outputArea.append("Pedido adicionado: Mesa " + mesa + ", Itens: " + itens + ", Status: " + status + "\n");
        listarPedidos(); // Atualiza a lista de pedidos na tabela
    }

    private void listarPedidos() {
        modeloTabela.setRowCount(0); // Limpa a tabela
        for (Pedido pedido : restaurante.getPedidos().values()) {
            modeloTabela.addRow(new Object[]{pedido.getIdPedido(), pedido.getMesa(), String.join(", ", pedido.getItens()), pedido.getStatus()});
        }
    }

    private void removerPedido() {
        int idPedido = Integer.parseInt(txtIdPedido.getText());
        try {
            restaurante.removerPedido(idPedido);
            outputArea.append("Pedido #" + idPedido + " removido.\n");
        } catch (PedidoNaoEncontradoException ex) {
            outputArea.append("Erro: " + ex.getMessage() + "\n");
        }
        listarPedidos(); // Atualiza a lista de pedidos na tabela
    }

    private void atualizarStatusPedido() {
        int idPedido = Integer.parseInt(txtIdPedido.getText());
        String novoStatus = txtStatus.getText();
        try {
            restaurante.atualizarStatusPedido(idPedido, novoStatus);
            outputArea.append("Status do Pedido #" + idPedido + " atualizado para: " + novoStatus + "\n");
        } catch (PedidoNaoEncontradoException ex) {
            outputArea.append("Erro: " + ex.getMessage() + "\n");
        }
        listarPedidos(); // Atualiza a lista de pedidos na tabela
    }

    public static void main(String[] args) {
        new RestauranteGUI();
    }
}


