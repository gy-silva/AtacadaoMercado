package org.Main;

import Utils.CsvToArray;
import Utils.Input;
import java.util.ArrayList;
import java.util.List;

public class CaixaDoAtacado {
    public static void computarCompra(){
        do{menuAtacado();
        }while (switchCase());
    }

    public static void menuAtacado() {
        System.out.println("SEJA BEM VINDO AO ATACADÃO");
        System.out.println("Como podemos lhe ajudar?");
        System.out.println("1 - MOSTRAR PRODUTOS");
        System.out.println("2 - ADICIONAR ITENS");
        System.out.println("3 - VER LISTA DE COMPRAS");
        System.out.println("4 - VER VALOR TOTAL DO PEDIDO");
        System.out.println("5 - IR PARA PAGAMENTO");
        System.out.println("6 - SAIR");
    }

    public static boolean switchCase(){
        List<ProdutoAtacado> produtos = new ArrayList<>();
        PedidoUsuario pedidoUsuario = PedidoUsuario.getInstance(produtos);
            System.out.println("ESCOLHA UMA OPÇÃO: ");

            switch(Input.inputInt()){
                case 1:
                    imprimeProdutos();
                    return true;
                case 2:
                    pedidoUsuario.addProduto();
                    return true;
                case 3:
                    pedidoUsuario.imprimeMapa();

                    return true;
                case 4:
                    pedidoUsuario.retornaCalculo();
                    return true;
                case 5:
                    pedidoUsuario.escolheMetodo();
                    return true;
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida");
                    return true;

            }
            return true;
        }

    public static List<ProdutoAtacado> imprimeProdutos(){
        String filePath = "ListaProdutosDoAtacado.CSV";
        List<ProdutoAtacado> produtos = CsvToArray.readCSV(filePath);
        for (ProdutoAtacado produto : produtos) {
            System.out.println(produto);
        }
        return produtos;
    }
}
