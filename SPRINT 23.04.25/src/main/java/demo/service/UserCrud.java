package demo.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import demo.entity.UserEntity;
import demo.entity.UserIdEntity;

@Repository
public interface UserCrud extends CrudRepository<UserEntity, UserIdEntity> {
	
	Optional<UserEntity> findByUserId_Email(String systemId, String email);

	Optional<UserEntity> findByUserId_EmailAndUserId_SystemId(String email, String systemId);
}
