package br.com;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
public class Atv20{
    public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("produtos.csv"))) {
            List<String[]> linhas = reader.readAll();
            linhas.remove(0); // Remover cabeçalho

            for (String[] linha : linhas) {
                String nome = linha[0];
                double preco = Double.parseDouble(linha[1]);
                int quantidade = Integer.parseInt(linha[2]);

                Produto produto = new Produto(nome, preco, quantidade);
                System.out.println(produto);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}