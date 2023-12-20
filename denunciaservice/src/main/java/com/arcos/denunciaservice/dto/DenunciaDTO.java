package com.arcos.denunciaservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DenunciaDTO {
	private int id;
	private String numerodocumento;
	private String titulo;
	private Date fecha;
	private String direccion;
	private String descripcion;
}
