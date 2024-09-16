package br.ufpb.dcx.anderson.restaurante;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private int idPedido;
    private String status;
    private List<String> itens;

    private String mesa;

    public Pedido(int idPedido, String status, List<String> itens, String mesa){
        this.idPedido = idPedido;
        this.status = "preparando"; //status inicial
        this.itens = itens;
        this.mesa = mesa;
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

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", status='" + status + '\'' +
                ", itens=" + itens +
                "' mesa=" + mesa +
                "}";
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

