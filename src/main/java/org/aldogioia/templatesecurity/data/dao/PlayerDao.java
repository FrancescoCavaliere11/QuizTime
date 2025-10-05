package org.aldogioia.templatesecurity.data.dao;

import org.aldogioia.templatesecurity.data.entities.redis.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDao extends CrudRepository<Player, String> {
}
