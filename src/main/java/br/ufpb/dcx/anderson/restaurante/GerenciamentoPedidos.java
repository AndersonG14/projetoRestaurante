package br.ufpb.dcx.anderson.restaurante;

import java.util.List;

public interface GerenciamentoPedidos {
    // Método para adicionar um novo pedido
    void adicionarPedido(String mesa, List<String> itens, String status);

    // Método para remover um pedido pelo ID
    void removerPedido(int idPedido) throws PedidoNaoEncontradoException;

    // Método para atualizar o status de um pedido
    void atualizarStatusPedido(int idPedido, String novoStatus) throws PedidoNaoEncontradoException;

    // Método para listar todos os pedidos
    void listarPedidos();
}
