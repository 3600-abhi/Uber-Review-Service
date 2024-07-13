package com.uber.reviewService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // Added so that createdAt & updatedAt filled automatically
@Getter
@Setter
public abstract class BaseModel {  // class is abstract to restrict its object creation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // means auto increment the PK and this field is handled by spring
    protected Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate // this annotation tell spring to only handle it for object creation
    protected Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this annotation tells spring about format of Date stored ie, Date, Time Or Timestamp
    @LastModifiedDate // this annotation tell spring to only handle it for object updation
    protected Date updatedAt;
}
