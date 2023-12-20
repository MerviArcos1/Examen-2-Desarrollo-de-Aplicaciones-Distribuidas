package com.arcos.denunciaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import com.arcos.denunciaservice.converter.DenunciaConverter;
import com.arcos.denunciaservice.dto.DenunciaDTO;
import com.arcos.denunciaservice.entity.Denuncia;
import com.arcos.denunciaservice.service.DenunciaService;

@RestController
@RequestMapping("/infracciones")
public class DenunciaController {
	
	@Autowired
	private DenunciaService service;
	
	@Autowired
	private DenunciaConverter converter;
	
	@GetMapping()
	public ResponseEntity<List<DenunciaDTO>>findAll(
		@RequestParam(value="numerodocumento", required=false,defaultValue="")String numerodocumento,
		@RequestParam(value="offset", required=false,defaultValue="0")int pageNumber,
		@RequestParam(value="limit", required=false,defaultValue="5")int pageSize
			){
		Pageable page=PageRequest.of(pageNumber, pageSize);
		List<Denuncia> denuncias;
		if(numerodocumento==null) {
			denuncias=service.findAll(page);
		}else {
			denuncias=service.findByNumerodocumento(numerodocumento, page);
		}
		
		if(denuncias.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		List<DenunciaDTO>denunciassDTO=converter.fromEntity(denuncias);
		return ResponseEntity.ok(denunciassDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<DenunciaDTO> findById(@PathVariable("id") int id){
		Denuncia denuncia = service.findById(id);
		if(denuncia==null) {
			return ResponseEntity.notFound().build();
		}
		DenunciaDTO denunciaDTO=converter.fromEntity(denuncia);
		return ResponseEntity.ok(denunciaDTO);
	}
	
	@PostMapping
	public ResponseEntity<DenunciaDTO> create(@RequestBody DenunciaDTO denunciaDTO){
		Denuncia registro=service.save(converter.fromDTO(denunciaDTO));
		DenunciaDTO registroDTO=converter.fromEntity(registro);
		return ResponseEntity.status(HttpStatus.CREATED).body(registroDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<DenunciaDTO> update(@PathVariable("id") int id,@RequestBody DenunciaDTO denunciaDTO){
		Denuncia registro =service.update(converter.fromDTO(denunciaDTO));
		if(registro==null) {
			return ResponseEntity.notFound().build();
		}
		DenunciaDTO registroDTO=converter.fromEntity(registro);
		return ResponseEntity.ok(registroDTO);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<DenunciaDTO>delete(@PathVariable("id") int id){
		service.delete(id);
		return ResponseEntity.ok(null);
	}
}
