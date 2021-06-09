package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

@Autowired	
private TopicoRepository topicoRepository;
	
	@GetMapping
	public List<TopicoDto>topicos (String nomeCurso){
		if(nomeCurso==null) {
		List<Topico>topicos = topicoRepository.findAll();
		
		return TopicoDto.converter(topicos);
		}else {
			List<Topico>topicos= topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
	}
	
	
	

}
