package br.ufpb.dcx.anderson.restaurante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurante implements GerenciamentoPedidos {
    private Map<Integer, Pedido> pedidos;
    private int contadorPedidos; // Para gerar IDs únicos para os pedidos

    // Construtor
    public Restaurante() {
        pedidos = new HashMap<>();
        contadorPedidos = 1;
    }

    // Adicionar novo pedido
    public void adicionarPedido(String mesa, List<String> itens, String status) {
        Pedido novoPedido = new Pedido(contadorPedidos, status, itens, mesa);
        pedidos.put(contadorPedidos, novoPedido);
        System.out.println("Pedido #" + contadorPedidos + " adicionado com sucesso.");
        contadorPedidos++;
    }

    // Remover pedido pelo ID
    public void removerPedido(int idPedido) throws PedidoNaoEncontradoException {
        if (pedidos.remove(idPedido) != null) {
            System.out.println("Pedido #" + idPedido + " removido.");
        } else {
            throw new PedidoNaoEncontradoException("Este pedido não está cadastrado");
        }
    }

    // Método para retornar todos os pedidos
    public Map<Integer, Pedido> getPedidos() {
        return pedidos;
    }


    // Listar todos os pedidos
    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
        } else {
            for (Pedido pedido : pedidos.values()) {
                pedido.toString();
                System.out.println();
            }
        }
    }

    public void atualizarStatusPedido(int idPedido, String novoStatus) throws PedidoNaoEncontradoException {
        Pedido pedido = pedidos.get(idPedido); // Busca o pedido pelo ID
        if (pedido != null) {
            pedido.setStatus(novoStatus); // Atualiza o status do pedido
            System.out.println("Status do Pedido #" + idPedido + " atualizado para: " + novoStatus);
        } else {
            throw new PedidoNaoEncontradoException("Pedido #" + idPedido + " não encontrado.");
        }
    }
}