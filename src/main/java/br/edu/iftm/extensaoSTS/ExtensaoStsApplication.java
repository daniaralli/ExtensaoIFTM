package br.edu.iftm.extensaoSTS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.extensaoSTS.domain.Atividade;
import br.edu.iftm.extensaoSTS.repositories.AtividadeRepository;

@SpringBootApplication
public class ExtensaoStsApplication implements CommandLineRunner{

	@Autowired
	private AtividadeRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(ExtensaoStsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception{
		Atividade a1 = new Atividade();
		a1.setNome("Simpos");
		repo.save(a1);
	}

}