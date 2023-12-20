package com.arcos.denunciaservice.validator;

import com.arcos.denunciaservice.entity.Denuncia;
import com.arcos.denunciaservice.exceptions.ValidateServiceException;

public class DenunciaValidator {
	public static void save(Denuncia denuncia) {
		if(denuncia.getNumerodocumento()==null||denuncia.getNumerodocumento().isEmpty()) {
			throw new ValidateServiceException("Numero de documento es requerido");
		}
		if(denuncia.getNumerodocumento().length()>100) {
			throw new ValidateServiceException("Numero de documento es muy largo");
		}
		if(denuncia.getFecha()==null) {
			throw new ValidateServiceException("La fecha es requerido");
		}
		if(denuncia.getTitulo()==null) {
			throw new ValidateServiceException("La falta es requerido");
		}
		if(denuncia.getTitulo().length()>30) {
			throw new ValidateServiceException("El titulo es muy largo");
		}
		if(denuncia.getDescripcion()==null) {
			throw new ValidateServiceException("La descripcion es requerido");
		}
		if(denuncia.getDireccion()==null) {
			throw new ValidateServiceException("La Direccion es requerida");
		}
		if(denuncia.getDireccion().length()>200) {
			throw new ValidateServiceException("la Direccion es muy larga");
		}
	}
}
