package application.amabient_intelligence.data.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import application.amabient_intelligence.data.IdGenerator;

public interface IdGeneratorCrud extends JpaRepository<IdGenerator, Long>{
	
}
