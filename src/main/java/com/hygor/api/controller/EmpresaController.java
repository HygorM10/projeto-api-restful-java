package com.hygor.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hygor.api.entities.Empresa;
import com.hygor.api.services.EmpresaService;

@RestController
@RequestMapping("/apiRest/hygor")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping(value = "/listarEmpresas")
	public List<Empresa> listarEmpresas(){
		return empresaService.listarEmpresas();
	}
}
