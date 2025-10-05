package org.aldogioia.templatesecurity.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.aldogioia.templatesecurity.security.logging.Auditable;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "quizzes")
public class Quiz extends Auditable {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "questions", joinColumns = @JoinColumn(name = "quiz_id"))
    List<Question> questions;
}
