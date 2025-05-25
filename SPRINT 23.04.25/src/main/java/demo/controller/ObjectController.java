	package demo.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.boundary.ObjectBoundary;
import demo.service.ObjectService;

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
   	public void updateMessage(@PathVariable("id") String id, @RequestBody ObjectBoundary update) {
   		this.objectService.updateObject(id, update);
   	}
     
    @GetMapping(
    	path = { "/{id}" }, 
    	produces = { MediaType.APPLICATION_JSON_VALUE })
    public ObjectBoundary getSingleInstance(@PathVariable("id") String id) {
    	return this.objectService
    		.getSingleInstance(id)
    		.orElseThrow(()-> 
    		new RuntimeException("could not find object with id: " + id)
    			);
    }
    
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<ObjectBoundary> getAllObjects() {
        return this.objectService.getAllObjects();
    }
	
}
