package application.amabient_intelligence.presatation.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.amabient_intelligence.logic.boundary.ObjectBoundary;
import application.amabient_intelligence.logic.exception.NotFoundException;
import application.amabient_intelligence.logic.service.ObjectService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path={"/ambient-intelligence/objects"})
public class ObjectController {

	private final ObjectService objectService;

    public ObjectController(ObjectService objectService) {
        this.objectService = objectService;
    }

    @PostMapping(
    		consumes = { MediaType.APPLICATION_JSON_VALUE }, 
    		produces = { MediaType.APPLICATION_JSON_VALUE })
    public ObjectBoundary createObject(@RequestBody ObjectBoundary input) {
        return this.objectService.createObject(input);
    }
    
    @PutMapping
    (path = { "/{id}" }, 
    consumes = { MediaType.APPLICATION_JSON_VALUE })
   	public void updateObject(@PathVariable("id") String id, @RequestBody ObjectBoundary update) {
   		this.objectService.updateObject(id, update);
   	}
    
    
    @GetMapping(
    	path = { "/{id}" }, 
    	produces = { MediaType.APPLICATION_JSON_VALUE })
    public ObjectBoundary getSingleInstance(@PathVariable("id") String id) {
    	return this.objectService
    		.getSingleInstance(id)
    		.orElseThrow(()-> 
    		new NotFoundException("could not find object with id: " + id)
    			);
    }
    
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ObjectBoundary[] getAllObjects() {
        return this.objectService.getAllObjects().toArray(new ObjectBoundary[0]);
    }
	
    @DeleteMapping("/objects")
	public void deleteAllObjects() {
        this.objectService.deleteAllObjects();		
	}

	
	

	

	
}
