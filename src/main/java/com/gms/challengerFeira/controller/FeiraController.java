package com.gms.challengerFeira.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gms.challengerFeira.dto.FeiraDTO;
import com.gms.challengerFeira.entity.Feira;
import com.gms.challengerFeira.repository.FeiraRepository;
import com.gms.challengerFeira.service.LogsService;

@RestController
@RequestMapping("/feiras")
public class FeiraController {

	@Autowired
	private FeiraRepository feiraRepository;
	
	@Autowired
	private LogsService logsService;

	@PostMapping
	@Transactional
	public ResponseEntity<FeiraDTO> create(@RequestBody @Valid Feira feira, UriComponentsBuilder uri,
			HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		feiraRepository.save(feira);
		URI uriPath = uri.path("/feiras/{id}").buildAndExpand(feira.getId()).toUri();
		logsService.gravarLogs(request.getMethod()+ " "+ request.getRequestURL().toString() + " Response: 200");
		return ResponseEntity.created(uriPath).body(new FeiraDTO(feira));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FeiraDTO> updated(@PathVariable Integer id, @RequestBody @Valid Feira feira, HttpServletRequest request) {
		Optional<Feira> optionalFeira = feiraRepository.findById(id);
		if (optionalFeira.isPresent()) {
			feiraRepository.save(feira);
			logsService.gravarLogs(request.getMethod()+ " "+request.getRequestURL().toString() + " Response: 200");
			return ResponseEntity.ok(new FeiraDTO(feira));
		}
		logsService.gravarLogs(request.getMethod()+ " "+request.getRequestURL().toString() + " Response: 404");
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Integer id, HttpServletRequest request) {
		Optional<Feira> optionalFeira = feiraRepository.findById(id);
		if (optionalFeira.isPresent()) {
			feiraRepository.deleteById(id);
			logsService.gravarLogs(request.getMethod()+ " "+request.getRequestURL().toString() + " Response: 200");
			return ResponseEntity.ok().build();
		}
		logsService.gravarLogs(request.getMethod()+ " "+request.getRequestURL().toString() + " Response: 404");
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<FeiraDTO>> search(String distrito, String regiao5, String nomeFeira, String bairro, HttpServletRequest request){
		if(distrito==null) {
			distrito="";
		}
		if(regiao5==null) {
			regiao5="";
		}
		if(nomeFeira==null) {
			nomeFeira="";
		}
		if(bairro==null) {
			bairro="";
		}
		List<Feira> feiras = new ArrayList<>();
		feiras = feiraRepository.findBySearchCriteria(distrito, regiao5, nomeFeira, bairro);
		if(feiras!=null && feiras.size()>0) {
			logsService.gravarLogs(request.getMethod()+ " "+request.getRequestURL().toString() + " Response: 200");
			return ResponseEntity.ok(FeiraDTO.converter(feiras));
		}
		logsService.gravarLogs(request.getMethod()+ " "+request.getRequestURL().toString() + " Response: 404");
		return ResponseEntity.notFound().build();
	}
}
