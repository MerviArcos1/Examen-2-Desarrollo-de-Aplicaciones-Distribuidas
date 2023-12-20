package com.arcos.denunciaservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arcos.denunciaservice.entity.Denuncia;
import com.arcos.denunciaservice.repository.DenunciaRepository;
import com.arcos.denunciaservice.service.DenunciaService;
import com.arcos.denunciaservice.validator.DenunciaValidator;

@Service
public class DenunciaServiceimpl implements DenunciaService{

	@Autowired
	private DenunciaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Denuncia> findAll(Pageable page) {
		try {
			return repository.findAll(page).toList();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Denuncia> findByNumerodocumento(String numerodocumento, Pageable page) {
		try {
			return repository.findByNumerodocumentoContaining(numerodocumento, page);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Denuncia findById(int id) {
		try {
			Denuncia registro=repository.findById(id).orElseThrow();
			return registro;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Denuncia save(Denuncia denuncia) {
		try {
			DenunciaValidator.save(denuncia);
			Denuncia registro=repository.save(denuncia);
			return registro;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Denuncia update(Denuncia denuncia) {
		try {
			DenunciaValidator.save(denuncia);
			Denuncia registro=repository.findById(denuncia.getId()).orElseThrow();
			registro.setNumerodocumento(denuncia.getNumerodocumento());
			registro.setFecha(denuncia.getFecha());
			registro.setFalta(denuncia.getTitulo());
			registro.setInfraccion(denuncia.getDireccion());
			registro.setDescripcion(denuncia.getDescripcion());
			repository.save(registro);
			return registro;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public void delete(int id) {
		try {
			Denuncia registro=repository.findById(id).orElseThrow();
			repository.delete(registro);
		}catch(Exception e){
			
		}
		
	}

}
