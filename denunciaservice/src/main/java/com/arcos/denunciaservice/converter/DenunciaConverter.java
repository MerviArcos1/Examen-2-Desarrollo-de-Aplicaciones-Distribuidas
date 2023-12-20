package com.arcos.denunciaservice.converter;

import org.springframework.stereotype.Component;

import com.arcos.denunciaservice.dto.DenunciaDTO;
import com.arcos.denunciaservice.entity.Denuncia;


@Component
public class DenunciaConverter extends AbstractConverter<Denuncia, DenunciaDTO> {

	@Override
	public DenunciaDTO fromEntity(Denuncia entity) {
		if(entity==null) return null;
		return DenunciaDTO.builder()
				.id(entity.getId())
				.numerodocumento(entity.getNumerodocumento())
				.fecha(entity.getFecha())
				.falta(entity.getTitulo())
				.infraccion(entity.getDireccion())
				.descripcion(entity.getDescripcion())
				.build();
	}

	@Override
	public Denuncia fromDTO(DenunciaDTO dto) {
		if(dto==null) return null;
		return Denuncia.builder()
				.id(dto.getId())
				.numerodocumento(dto.getNumerodocumento())
				.fecha(dto.getFecha())
				.titulo(dto.getTitulo())
				.direccion(dto.getDireccion())
				.descripcion(dto.getDescripcion())
				.build();
	}

}
