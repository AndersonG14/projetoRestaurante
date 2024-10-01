package br.ufpb.dcx.anderson.restaurante;

import br.ufpb.dcx.anderson.restaurante.controller.RestauranteAddController;
import br.ufpb.dcx.anderson.restaurante.controller.RestauranteAtualizarStatusPedidoController;
import br.ufpb.dcx.anderson.restaurante.controller.RestauranteListarPedidosController;
import br.ufpb.dcx.anderson.restaurante.controller.RestauranteRemoveController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RestauranteGUI extends JFrame {
    private Restaurante restaurante;
    private JTextField txtMesa, txtItens, txtStatus, txtIdPedido;
    private JTextArea outputArea;
    private JTable tabelaPedidos;

    public RestauranteGUI() {
        restaurante = new Restaurante();

        setTitle("Gerenciamento de Pedidos - Restaurante");
        setSize(600, 500); // Ajuste o tamanho da janela para acomodar a imagem
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
        String[] colunas = {"ID", "Mesa", "Itens", "Status"};
        tabelaPedidos = new JTable(new DefaultTableModel(new Object[][]{}, colunas));
        add(new JScrollPane(tabelaPedidos), BorderLayout.SOUTH);

        // Adicionando imagem ao painel (pode ser um logo do restaurante ou outra imagem relevante)
        JLabel labelImagem = new JLabel();
        ImageIcon imagem = new ImageIcon("C:\\Users\\Anderson Gomes\\Downloads\\restaurante,jpg"); // Substitua pelo caminho da sua imagem
        labelImagem.setIcon(imagem);
        labelImagem.setHorizontalAlignment(SwingConstants.CENTER); // Centralizar a imagem no JLabel
        add(labelImagem, BorderLayout.WEST); // Colocando a imagem no lado esquerdo da interface

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

        // Configurando controladores para os botões
        RestauranteAddController addController = new RestauranteAddController(
                restaurante, txtMesa, txtItens, txtStatus, outputArea, tabelaPedidos
        );
        btnAdicionar.addActionListener(addController);

        RestauranteListarPedidosController listController = new RestauranteListarPedidosController(
                restaurante, tabelaPedidos
        );
        btnListar.addActionListener(listController);

        RestauranteRemoveController removeController = new RestauranteRemoveController(
                restaurante, txtIdPedido, outputArea, tabelaPedidos
        );
        btnRemover.addActionListener(removeController);

        RestauranteAtualizarStatusPedidoController updateController = new RestauranteAtualizarStatusPedidoController(
                restaurante, txtIdPedido, txtStatus, outputArea, tabelaPedidos
        );
        btnAtualizar.addActionListener(updateController);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RestauranteGUI();
    }
}
