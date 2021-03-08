package com.ctt.agenda.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctt.agenda.dto.input.ContatoDtoInput;
import com.ctt.agenda.dto.output.ContatoDtoOutput;
import com.ctt.agenda.dto.output.EnderecoDtoOutput;
import com.ctt.agenda.dto.output.TelefoneDtoOutput;
import com.ctt.agenda.entity.Contato;
import com.ctt.agenda.entity.Endereco;
import com.ctt.agenda.entity.Telefone;
import com.ctt.agenda.repository.EnderecoRepository;
import com.ctt.agenda.repository.TelefoneRepository;

@Service
public class ContatoConverter {

	@Autowired
	private EnderecoConverter enderecoConverter;

	@Autowired
	private TelefoneConverter telefoneConverter;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Contato dtoToModel(ContatoDtoInput contatoDtoInput) {
		Contato contato = new Contato();
		return this.dtoToModel(contatoDtoInput, contato);
	}

	public Contato dtoToModel(ContatoDtoInput contatoDtoInput, Contato contato) {
		contato.setNome(contatoDtoInput.getNome());
		Telefone telefone = telefoneRepository.findById(contatoDtoInput.getIdTelefone()).get();
		Endereco endereco = enderecoRepository.findById(contatoDtoInput.getIdEndereco()).get();
		contato.setTelefone(telefone);
		contato.setEndereco(endereco);
		return contato;
	}

	public ContatoDtoOutput modelToDto(Contato contato) {
		ContatoDtoOutput contatoDtoOutput = new ContatoDtoOutput();
		contatoDtoOutput.setId(contato.getId());
		contatoDtoOutput.setNome(contato.getNome());

		Telefone telefone = contato.getTelefone();
		Endereco endereco = contato.getEndereco();

		TelefoneDtoOutput telefoneDtoOutput = this.telefoneConverter.modelToDto(telefone);
		EnderecoDtoOutput enderecoDtoOutput = this.enderecoConverter.modelToDto(endereco);

		contatoDtoOutput.setTelefone(telefoneDtoOutput);
		contatoDtoOutput.setEndereco(enderecoDtoOutput);

		return contatoDtoOutput;
	}

	public List<ContatoDtoOutput> modelToDto(List<Contato> contatos) {
		List<ContatoDtoOutput> contatosDtos = new ArrayList<ContatoDtoOutput>();
		for (Contato contato : contatos) {
			contatosDtos.add(this.modelToDto(contato));
		}
		return contatosDtos;
	}

}