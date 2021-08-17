package com.hygor.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hygor.api.entities.Empresa;
import com.hygor.api.repositories.EmpresaRepository;

@SpringBootApplication
public class ProjetoApiRestfulCursoApplication {
	
	@Autowired
	private EmpresaRepository empresaRepository; 

	public static void main(String[] args) {
 		SpringApplication.run(ProjetoApiRestfulCursoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Hygor Martins TI");
			empresa.setCnpj("123456789");
			
			this.empresaRepository.save(empresa);
			
			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			Optional<Empresa> empresaDb = empresaRepository.findById(1L);
			System.out.println("Empres por ID: " + empresaDb);
			
			empresaDb.get().setRazaoSocial("Nova Razão Social Hygor");
			this.empresaRepository.save(empresaDb.get());
			
			empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			this.empresaRepository.deleteById(1L);
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: " +  empresas.size());
			
		};
	}

}
