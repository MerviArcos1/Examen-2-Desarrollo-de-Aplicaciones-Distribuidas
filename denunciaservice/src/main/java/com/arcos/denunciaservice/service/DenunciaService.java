package com.arcos.denunciaservice.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.arcos.denunciaservice.entity.Denuncia;

public interface DenunciaService {
	public List<Denuncia>findAll(Pageable page);
	public List<Denuncia>findByNumerodocumento(String numerodocumento, Pageable page);
	public Denuncia findById(int id);
	public Denuncia save(Denuncia denuncia);
	public Denuncia update(Denuncia denuncia);
	public void delete(int id);
	
}
