package com.uber.reviewService.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Data
@Builder
@EntityListeners(AuditingEntityListener.class) // Added so that createdAt & updatedAt filled automatically
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // means auto increment the PK and this field is handled by spring
    private Long id;

    @Column(nullable = false)
    private String content;

   private Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate // this annotation tell spring to only handle it for object creation
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this annotation tells spring about format of Date stored ie, Date, Time Or Timestamp
    @LastModifiedDate // this annotation tell spring to only handle it for object updation
   private Date updatedAt;

}
