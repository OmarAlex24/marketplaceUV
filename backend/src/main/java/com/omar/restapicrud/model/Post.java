package com.omar.restapicrud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "posts")
@Setter
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Date publicationDate;

    @Column
    private Long articlePrice;

    @Column
    private Long categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private User postOwner;

    @Column
    private String ownerCampus;

    public Post(String title, String description, Date publicationDate, Long articlePrice, Long categoryId, User owner) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.articlePrice = articlePrice;
        this.categoryId = categoryId;
        this.postOwner = owner;
        this.ownerCampus = owner.getUserCampus().getCampusName();
    }

}
