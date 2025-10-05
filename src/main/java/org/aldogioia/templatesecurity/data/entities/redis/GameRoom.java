package org.aldogioia.templatesecurity.data.entities.redis;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;
import java.util.UUID;

@RedisHash(value = "GameRoom", timeToLive = 3600)   // todo set timeToLive to 1 hour
@Data
public class GameRoom {
    @Id
    private String id = UUID.randomUUID().toString();

    private String quizId;

    private String code;

    private List<String> playerIds;
}
