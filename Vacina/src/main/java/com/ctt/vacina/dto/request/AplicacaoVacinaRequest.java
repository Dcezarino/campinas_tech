package com.ctt.vacina.dto.request;

import java.util.Date;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class AplicacaoVacinaRequest {

	@Size(min = 1, max = 20)
	private String nomeDaVacina;

	@PastOrPresent
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataDaVacina;

	@NotNull
	@Positive
	private Long idUsuario;

}
