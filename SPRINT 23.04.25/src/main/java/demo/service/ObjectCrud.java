package demo.service;

import org.springframework.data.repository.CrudRepository;

import demo.entity.ObjectEntity;
import demo.entity.ObjectIdEntity;

public interface ObjectCrud extends CrudRepository<ObjectEntity, ObjectIdEntity>{

}
