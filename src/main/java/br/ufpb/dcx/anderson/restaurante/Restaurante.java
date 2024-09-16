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
    public void adicionarPedido(String mesa, List<String> itens) {
        Pedido novoPedido = new Pedido(contadorPedidos, mesa, itens);
        pedidos.put(contadorPedidos, novoPedido);
        System.out.println("Pedido #" + contadorPedidos + " adicionado com sucesso.");
        contadorPedidos++;
    }

    // Remover pedido pelo ID
    public void removerPedido(int idPedido) {
        if (pedidos.remove(idPedido) != null) {
            System.out.println("Pedido #" + idPedido + " removido.");
        } else {
            System.out.println("Pedido não encontrado.");
        }
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
}