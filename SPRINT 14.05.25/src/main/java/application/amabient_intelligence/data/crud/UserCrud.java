package application.amabient_intelligence.data.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.amabient_intelligence.data.entity.UserEntity;

@Repository
public interface UserCrud extends JpaRepository<UserEntity, String> {
	Optional<UserEntity> findByEmail(String userEmail);

	Optional<UserEntity> findByEmailAndSystemID(String userEmail, String systemId);
}
