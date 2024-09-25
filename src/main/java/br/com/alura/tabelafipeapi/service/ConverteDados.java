package br.com.alura.tabelafipeapi.service;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ConverteDados implements IConverteDados {
    

    @Override
    public <T> T obterDados(String json, Class<T> classe) {

// Aqui estou fazendo a conversão do json para a classe que for determinada
        try{
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
}

}
