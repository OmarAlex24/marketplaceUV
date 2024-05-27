package com.omar.restapicrud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "campuses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonBackReference
    private Long campusId;

    @Column(nullable = false)
    private String campusName;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region regionId;

    @OneToMany(mappedBy = "userCampus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<User> users;

    public Campus(Long campusId, String campusName, Region regionId) {
        this.campusId = campusId;
        this.campusName = campusName;
        this.regionId = regionId;
    }
}
