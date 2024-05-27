package com.omar.restapicrud.controller;

import com.omar.restapicrud.dto.CampusDTO;
import com.omar.restapicrud.model.Campus;
import com.omar.restapicrud.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/campus")
public class CampusController {

    @Autowired
    private CampusService campusService;

    @PostMapping()
    public Campus createCampus(@RequestBody CampusDTO campus) {
        return campusService.createCampus(campus);
    }

    @GetMapping
    public List<Campus> getAllCampuses() {
        return campusService.listAllCampuses();
    }

    @GetMapping("/{id}")
    public Campus getCampusById(@PathVariable Long id) {
        return campusService.getCampusById(id);
    }

    @GetMapping("/{id}/remove")
    public void removeCampus(@PathVariable Long id) throws Exception {
        campusService.removeCampus(id);
    }
}
