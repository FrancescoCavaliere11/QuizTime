package org.aldogioia.templatesecurity.data.dao;

import org.aldogioia.templatesecurity.data.entities.redis.GameRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRoomDao extends CrudRepository<GameRoom, String> {
}
