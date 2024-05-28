package com.omar.restapicrud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    private Long campusId;

    @Column(nullable = false)
    private String campusName;

    @ManyToOne
    @JoinColumn(name = "regionId", nullable = false)
    @JsonBackReference
    private Region region;

    @JsonInclude
    public String getCampusRegion() {
        return region.getRegionName();
    }

    @OneToMany(mappedBy = "userCampus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<User> users;

    public Campus(String campusName, Region region) {
        this.campusName = campusName;
        this.region = region;
    }
}
