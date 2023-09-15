package org.Main;

import java.util.List;
import java.util.Map;

public class Calcular {
        private List<ProdutoAtacado> listaMercadoria;
        public Calcular(List<ProdutoAtacado> listaMercadoria) {

            this.listaMercadoria = listaMercadoria;
        }

        public double calcularTotal(Map<Integer, Integer> pedido) {
            double total = 0;
            double desconto = 0;

            for (Map.Entry<Integer, Integer> entry : pedido.entrySet()) {
                int idItem = entry.getKey();
                int quantidade = entry.getValue();

                ProdutoAtacado produto = encontrarProdutoPorId(idItem);

                if (produto != null) {
                    total += produto.getPreco() * quantidade;
                }

                if (quantidade <= 5) {
                    //até 5 unidades: sem desconto
                    total += produto.getPreco() * quantidade;
                } else
                    if (quantidade <= 15) {
                    // de 5 a 15 unidades: 10% de desconto
                    double subtotal = produto.getPreco() * quantidade;
                    desconto += subtotal * 0.10;
                    total += subtotal - desconto;
                    System.out.println("Desconto de 10% concedido, pela quantidade de unidades comprada, no valor de: R$ " + desconto);
                } else
                    if (quantidade <= 25) {
                    // de 15 a 25 unidades: 20% de desconto
                    double subtotal = produto.getPreco() * quantidade;
                    desconto += subtotal * 0.20;
                    total += subtotal - desconto;
                    System.out.println("Desconto de 20% concedido, pela quantidade de unidades comprada, no valor de: R$ " + desconto);
                } else {
                    // mais de 25 unidades: 25% de desconto
                    double subtotal = produto.getPreco() * quantidade;
                    desconto += subtotal * 0.25;
                    total += subtotal - desconto;
                    System.out.println("Desconto de 25% concedido, pela quantidade de unidades comprada, no valor de: R$ " + desconto);
                }
            }

            return total;
        }

        private ProdutoAtacado encontrarProdutoPorId(int id) {
            for (ProdutoAtacado produto : listaMercadoria) {
                if (produto.getId() == id) {
                    return produto;
                }
            }
            return null;
        }

}
