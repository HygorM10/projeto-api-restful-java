package com.hygor.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hygor.api.entities.Empresa;
import com.hygor.api.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository; 
	
	public boolean salvarEmpresa(Empresa empresa) {
		
		try {
			this.empresaRepository.save(empresa);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	public List<Empresa> listarEmpresas(){
		return empresaRepository.findAll();
	}
	
	public Empresa buscarEmpresa(Long id) {
		Optional<Empresa> empresa = empresaRepository.findById(id);
		return empresa.get();
	}
}
