package com.omar.restapicrud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;

  @Column
  private String name;

  @Column
  private String lastName;

  @Column
  private String carnetNumber;

  @Column
  private String schoolMail;

  @Column
  private String password;

  @ManyToOne
  @JoinColumn(name = "campus_id", nullable = false)
  @JsonBackReference
  private Campus userCampus;

  @OneToMany(mappedBy = "postOwner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Post> userPosts;

  @Column
  private String clabe;

  public User(String name, String lastName, String carnetNumber, String schoolMail, String password, Campus campus) {
    this.name = name;
    this.lastName = lastName;
    this.carnetNumber = carnetNumber;
    this.schoolMail = schoolMail;
    this.password = password;
    this.userCampus = campus;
  }

  public User(String name, String lastName, String carnetNumber, String schoolMail, String password, Campus campus, String clabe) {
    this.name = name;
    this.lastName = lastName;
    this.carnetNumber = carnetNumber;
    this.schoolMail = schoolMail;
    this.password = password;
    this.userCampus = campus;
    this.clabe = clabe;
  }
}
