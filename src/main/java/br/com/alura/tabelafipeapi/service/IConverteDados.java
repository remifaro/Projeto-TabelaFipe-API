package br.com.alura.tabelafipeapi.service;

public interface IConverteDados {

// Aqui ele converte a classe, não importa qual seja, para o tipo que escolhermos, no caso String    
    <T> T obterDados(String json, Class<T> classe);
}
