package org.aldogioia.templatesecurity.data.entities.redis;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash(value = "Player", timeToLive = 3600)   // todo set timeToLive to 1 hour
@Data
public class Player {
    @Id
    private String id = UUID.randomUUID().toString();

    private String nickname;

    private int score;

    private String roomId;
}
