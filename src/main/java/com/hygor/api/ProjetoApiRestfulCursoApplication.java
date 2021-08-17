package com.hygor.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hygor.api.entities.Empresa;
import com.hygor.api.services.EmpresaService;

@SpringBootApplication
public class ProjetoApiRestfulCursoApplication {

	public static void main(String[] args) {
 		SpringApplication.run(ProjetoApiRestfulCursoApplication.class, args);
	}
	
	@Autowired
	private EmpresaService empresaService;
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Hygor Martins TI");
			empresa.setCnpj("123456789");
			
			empresaService.salvarEmpresa(empresa);
			
			List<Empresa> empresas = empresaService.listarEmpresas();
			empresas.forEach(System.out::println);
			
			Empresa empresaDb = empresaService.buscarEmpresa(1L);
			System.out.println("Empres por ID: " + empresaDb);
			
			empresaDb.setRazaoSocial("Nova Razão Social Hygor");
			empresaService.salvarEmpresa(empresaDb);
			
			empresas = empresaService.listarEmpresas();
			empresas.forEach(System.out::println);
			
		};
	}

}
