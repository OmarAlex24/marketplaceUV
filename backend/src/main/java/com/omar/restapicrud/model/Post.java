package com.omar.restapicrud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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
    private Integer quantity;

    @Column
    private Long categoryId;

    @Column
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private User postOwner;

    @Column
    private String ownerCampus;

    @ManyToMany(mappedBy = "userComments")
    @JsonManagedReference
    private List<User> usersComments;

    @ManyToMany(mappedBy = "userFavoritePosts")
    @JsonBackReference
    private List<User> favoritedByUsers;


    public Post(String title, String description, Date publicationDate, Long articlePrice, Integer quantity, Long categoryId, User owner) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.articlePrice = articlePrice;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.postOwner = owner;
        this.ownerCampus = owner.getUserCampus().getCampusName();
        this.isActive = true;
    }

}
