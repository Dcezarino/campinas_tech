package com.ctt.vacina.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ctt.vacina.dto.request.UsuarioRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
@Entity
public class Usuario {
	
	// Método recebendo o usuarioRequest e chamando o fillFromDto
	public Usuario(UsuarioRequest usuarioRequest) {
		this.fillFromDto(usuarioRequest);
	}
	
	public void fillFromDto(UsuarioRequest usuarioRequest) {
		this.setCpf(usuarioRequest.getCpf());
		this.setDataNascimento(usuarioRequest.getDataNascimento());
		this.setEmail(usuarioRequest.getEmail());
		this.setNome(usuarioRequest.getNome());	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false,  length = 80, unique = true)
	private String email;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, length = 11, unique = true)
	private String cpf;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataNascimento;

}
