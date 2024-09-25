package br.com.alura.tabelafipeapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.tabelafipeapi.principal.Principal;

@SpringBootApplication
public class TabelafipeapiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TabelafipeapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Principal principal = new Principal();
		principal.exibeMenu();
	}

}
