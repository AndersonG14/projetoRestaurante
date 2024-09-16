package br.ufpb.dcx.anderson.restaurante;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private int idPedido;
    private String status;
    private List<String> itens;

    public Pedido(int idPedido, String status, List<String> itens){
        this.idPedido = idPedido;
        this.status = "preparando"; //status inicial
        this.itens = itens;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", status='" + status + '\'' +
                ", itens=" + itens +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return idPedido == pedido.idPedido && Objects.equals(status, pedido.status) && Objects.equals(itens, pedido.itens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, status, itens);
    }
}

