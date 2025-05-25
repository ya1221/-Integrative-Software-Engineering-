package application.amabient_intelligence.data.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.amabient_intelligence.data.entity.CommandEntity;

@Repository
public interface CommandCrud extends JpaRepository<CommandEntity, Long> {

}