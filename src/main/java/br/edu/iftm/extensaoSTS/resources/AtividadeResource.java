package br.edu.iftm.extensaoSTS.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.iftm.extensaoSTS.domain.Atividade;
import br.edu.iftm.extensaoSTS.repositories.AtividadeRepository;


@RestController
@RequestMapping(value="/atividades")
public class AtividadeResource {
   
	
	@Autowired
	private AtividadeRepository repo;
	
	
	@GetMapping(value= "{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		
		Optional<Atividade> atividadeOptional = repo.findById(id);
		
		if(atividadeOptional.isPresent()) {
			return ResponseEntity.ok(atividadeOptional);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping(value="like/{nome}")
	public ResponseEntity<?> findByNome(@PathVariable String nome){
		
		List<Atividade> atividades = repo.findByNomeContainingIgnoreCase(nome);
		if(atividades.size() > 0) {
			return ResponseEntity.ok(atividades);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Atividade atividade){
		
		Atividade a = repo.save(atividade);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		
		try {
			
			repo.deleteById(id);
			return ResponseEntity.ok(id);
		}
		catch(EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
			
		}
		
	}
    //@RequestMapping(method=RequestMethod.GET)
    /*public String listar(){
        return "Rest ok";
       
    }*/
    /*@RequestMapping(method=RequestMethod.GET)
    public List<Atividade> listar(){
    	Atividade a1 = new Atividade(1,"visita tecnica gdg");
    	Atividade a2 = new Atividade(2,"simpos");
    	return Arrays.asList(a1,a2);
    }*/
	
	
	/*@Autowired
    private AtividadeService service;*/
	
	/*@RequestMapping(value="{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Atividade atividade = service.buscar(id);
		return ResponseEntity.ok().body(atividade);
	}*/
	
	/*@RequestMapping(value="{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		try {
			Atividade atividade = service.buscar(id);
			return ResponseEntity.ok(atividade);
		}catch(NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}*/

}