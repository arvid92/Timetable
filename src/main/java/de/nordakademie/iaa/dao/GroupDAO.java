package de.nordakademie.iaa.dao;

import de.nordakademie.iaa.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO for group entities.
 *
 * @author Arvid Ottenberg
 */
public interface GroupDAO extends JpaRepository<Group, Long> {
}
