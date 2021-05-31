package com.clinicamedica.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.clinicamedica.dto.BeneficiarioDTO;
import com.clinicamedica.dto.DadosParaEmailDTO;
import com.clinicamedica.dto.DesativaAtivaBenefDTO;
import com.clinicamedica.service.BeneficiarioService;

@RestController
@RequestMapping(value = "/api-beneficiario")
public class beneficiarioController {	

	@Autowired
	private BeneficiarioService proxybenef;
	
	@Autowired
	private static Logger log = LoggerFactory.getLogger(beneficiarioController.class);
	
	@GetMapping(value = "/busca-beneficiario-id/{id}")
	public ResponseEntity<?> buscaBeneficiarioid(@PathVariable int id) {
	  log.info("Buscando por id");
	  BeneficiarioDTO benef	= proxybenef.findByIdService(id);
	  return new ResponseEntity<>(benef,HttpStatus.OK);
	}
	
	@GetMapping(value = "/busca-beneficiario-nome/{nome}")
	public ResponseEntity<?> buscaBeneficiarioid(@PathVariable String nome) {
	List<BeneficiarioDTO> benef	= proxybenef.findlikeService(nome);
	  return new ResponseEntity<>(benef,HttpStatus.OK);
	}
	
	@GetMapping(value = "/busca-todos-beneficiario")
	public ResponseEntity<?> bustodosbeneficario(){
		 List<BeneficiarioDTO> benef	= proxybenef.findAllService();
		  return new ResponseEntity<>(benef,HttpStatus.OK);	
	}
	
	@PostMapping(value = "/inserir-beneficiario")
	public ResponseEntity<?> inserirbeneficario(@RequestBody BeneficiarioDTO obj){
		  BeneficiarioDTO benef = proxybenef.InserirBeneficiario(obj);
		  return new ResponseEntity<>(benef,HttpStatus.CREATED);	
	}
	
	@PutMapping(value = "/desativa-ativa-beneficiario")
	public ResponseEntity<?> desativaAtivaBenef(@RequestBody DesativaAtivaBenefDTO obj){
		proxybenef.DesativaAtivaBeneficiario(obj.getId(), obj.getStatus());
		return new ResponseEntity<>("OK",HttpStatus.OK);
	}
	
	@PutMapping(value = "/update-beneficiario")
	public ResponseEntity<?> updateBenef(@RequestBody BeneficiarioDTO obj){
		BeneficiarioDTO benef = proxybenef.UpdateBeneficiario(obj);
		return new ResponseEntity<>(benef,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "homeBenef")
	public ModelAndView homeBeneficiarioClinicaMedica(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView("view/homeBeneficiario");
		DadosParaEmailDTO dto = new DadosParaEmailDTO("Willyan Fernando","000123465465","wf.cirino@bol.com.br",new Date(System.currentTimeMillis()),
													  "Assunto Teste","Teste com email");
		view.addObject("dadoEmail", dto);
		//Map param = new HashMap();
		//param.clear();
		//param.put("listUf", listUf);
		//view = view.addAllObjects(param);
		return view;
	}
	
	
	

}
