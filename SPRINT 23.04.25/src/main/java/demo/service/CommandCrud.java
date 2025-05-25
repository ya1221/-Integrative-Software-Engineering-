package demo.service;

import org.springframework.data.repository.CrudRepository;
import demo.entity.CommandEntity;
import demo.entity.CommandIdEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandCrud extends CrudRepository<CommandEntity, CommandIdEntity> {

}