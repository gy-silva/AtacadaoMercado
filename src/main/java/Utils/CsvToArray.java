package Utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.Main.ProdutoAtacado;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToArray {
    public static List<ProdutoAtacado> readCSV(String nomeDoArquivo) {
        String filePath = "resources"+ File.separator+nomeDoArquivo;
        List<ProdutoAtacado> produtos = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> lines = reader.readAll();
            lines.remove(0); // Remover cabeçalho

            for (String[] line : lines) {
                int id = Integer.parseInt(line[0].trim());
                String nome = line[1].trim();
                double preco = Double.parseDouble(line[2].trim());

                ProdutoAtacado produto = new ProdutoAtacado(id, nome, preco);
                produtos.add(produto);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}