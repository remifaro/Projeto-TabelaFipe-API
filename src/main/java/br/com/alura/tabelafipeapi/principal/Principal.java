package br.com.alura.tabelafipeapi.principal;

import java.util.Scanner;

import br.com.alura.tabelafipeapi.service.ConsumoApi;

public class Principal {

        private Scanner leitura = new Scanner(System.in);
        private ConsumoApi consumo = new ConsumoApi();

        private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

        public void exibeMenu(){
            System.out.println("**** OPÇÕES **** \n Carro \n Moto \n Caminhão \n \n Digite uma das opções para consultar valores:");
            var opcaoInicial = leitura.nextLine();
            var json = consumo.obterDados(ENDERECO + opcaoInicial);
            
            System.out.println(json);
        }
        
}
