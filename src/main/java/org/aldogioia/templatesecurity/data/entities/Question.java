package org.aldogioia.templatesecurity.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Embeddable
public class Question {
    @Column(name = "question", nullable = false)
    private String question;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "answers", joinColumns = @JoinColumn(name = "question_id"))
    List<Answer> answers;
}
