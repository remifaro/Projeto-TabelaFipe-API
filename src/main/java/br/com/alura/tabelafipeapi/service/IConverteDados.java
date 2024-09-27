package br.com.alura.tabelafipeapi.service;

import java.util.List;

public interface IConverteDados {

// Aqui ele converte a classe, não importa qual seja, para o tipo que escolhermos, no caso String    
    <T> T obterDados(String json, Class<T> classe);

    <T> List<T> obterLista(String json, Class<T> classe);
}
