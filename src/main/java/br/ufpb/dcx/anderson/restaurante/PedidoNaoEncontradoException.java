package br.ufpb.dcx.anderson.restaurante;

public class PedidoNaoEncontradoException extends Exception{
    public PedidoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}