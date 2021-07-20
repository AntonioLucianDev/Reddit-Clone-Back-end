package com.asusoftware.ReditClone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "subreddits")
public class Subreddit {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;


    @NotBlank(message = "Community name is required")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Description is required")
    @Column(name = "description")
    private String description;

    @OneToMany(fetch = LAZY)
    private List<Post> posts;

    @Column(name = "created_date")
    private Instant createdDate;

    @ManyToOne(fetch = LAZY)
    private User user;
}