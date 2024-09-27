package br.com.alura.tabelafipeapi.principal;

import java.util.Comparator;
import java.util.Scanner;

import br.com.alura.tabelafipeapi.model.Dados;
import br.com.alura.tabelafipeapi.model.Modelos;
import br.com.alura.tabelafipeapi.service.ConsumoApi;
import br.com.alura.tabelafipeapi.service.ConverteDados;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        var menu = """
                **** OPÇÕES ****
                Carro
                Moto
                Caminhão

                Digite uma das opções para consultar valores:
                        """;

        System.out.println(menu);
        var opcao = leitura.nextLine();

        String endereco;

        if (opcao.toLowerCase().contains("carr")){
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")){
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);

        var marcas = conversor.obterLista(json, Dados.class);

        // Agora vamos exibir essas marcas, por ordem do código
        marcas.stream() 
            .sorted(Comparator.comparing(Dados::codigo))
            .forEach(System.out::println);


        System.out.println("Informe o código da marca para consulta:");
        var codigoMarca = leitura.nextLine();

        endereco = endereco + "/" +codigoMarca + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = conversor.obterDados(json, Modelos.class);

        System.out.println("\nModelos dessa marca: ");
        modeloLista.modelos().stream()
            .sorted(Comparator.comparing(Dados::codigo))
            .forEach(System.out::println);
    }

}
