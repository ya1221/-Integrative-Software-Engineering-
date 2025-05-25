package application.amabient_intelligence.data.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.amabient_intelligence.data.entity.ObjectEntity;

@Repository
public interface ObjectCrud extends JpaRepository<ObjectEntity, Long> {
	Optional<ObjectEntity> findBySystemIDAndObjectId(@Param("systemID")String systemID, @Param("objectId")Long objectId);
}
