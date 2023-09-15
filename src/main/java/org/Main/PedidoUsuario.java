package org.Main;

import Utils.CsvToArray;
import Utils.Input;

import java.util.*;

public class PedidoUsuario {

    private static PedidoUsuario instanciaUnica = null;
    List<ProdutoAtacado> listaMercadoria = new ArrayList<>();
    Map<Integer, Integer> pedido = new HashMap<>();
    private Calcular calcular;
    String metodoPagamento;

    public PedidoUsuario(String produto) {
        listaMercadoria = CsvToArray.readCSV("ListaProdutosDoAtacado.CSV");
        calcular = new Calcular(listaMercadoria);
    }

    public static PedidoUsuario getInstance(List<ProdutoAtacado> produto) {
        if (instanciaUnica == null) {
            instanciaUnica = new PedidoUsuario(produto.toString());
        }
        return instanciaUnica;
    }

    public void addProduto() {

        System.out.println("Qual o ID do(s) produtos que você deseja? ");
        int idItem = Input.inputInt();

        System.out.println("Qual a quantidade do(s) produtos que você deseja? ");
        int qnt = Input.inputInt();

        pedido.put(idItem, qnt);

    }

    public void imprimeMapa() {
        System.out.println("Itens no pedido:");

        for (Map.Entry<Integer, Integer> entry : pedido.entrySet()) {
            int idItem = entry.getKey();
            int quantidade = entry.getValue();

            ProdutoAtacado produto = encontrarProdutoPorId(idItem);

            if (produto != null) {
                System.out.println("ID do Item: " + idItem);
                System.out.println("Nome do Produto: " + produto.getNome());
                System.out.println("Valor do Produto: " + produto.getPreco());
                System.out.println("Quantidade: " + quantidade);
                System.out.println("-----------------------------");
            } else {
                System.out.println("Item com ID " + idItem + " não encontrado na lista de mercadorias.");
            }
        }
    }
    ProdutoAtacado encontrarProdutoPorId(int id) {
        for (ProdutoAtacado produto : listaMercadoria) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado na lista.");
        return null;
    }

    public void retornaCalculo(){
        double total = calcular.calcularTotal(pedido);
        System.out.println("O valor total do pedido é: " + total);

    }

    public void escolheMetodo(){
        System.out.println("Qual método de pagamanto que você deseja? ");
        metodoPagamento = Input.inputString();
        double totalPagamento = 0;

            //sem desconto
        if(metodoPagamento.equals("debito")){
            totalPagamento = calcular.calcularTotal(pedido);
            System.out.println("O valor total do pedido, sem desconto, por método de pagamento é de R$: " + totalPagamento);

            //com acréscimo de 3%
        } else if(metodoPagamento.equals("credito")){
            double totalSemAcrescimo = calcular.calcularTotal(pedido);
            double acrescimo = 0.03 * totalSemAcrescimo;
            totalPagamento = totalSemAcrescimo + acrescimo;
            System.out.println("O valor total do pedido com acréscimo de 3%, por método de pagamento é de R$: " + totalPagamento);

            //com desconto de 5%
        }else if(metodoPagamento.equals("dinheiro")){
            double totalSemDesconto = calcular.calcularTotal(pedido);
            double desconto = 0.05 * totalSemDesconto;
            totalPagamento = totalSemDesconto - desconto;
            System.out.println("O valor total do pedido, com desconto de 5%, por método de pagamento é de R$: " + totalPagamento);
        }

    }

}



