package com.omar.restapicrud.controller;

import com.omar.restapicrud.model.Region;
import com.omar.restapicrud.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @PostMapping()
    public Region createRegion(@RequestBody Region region) {
        return regionService.createRegion(region);
    }

    @GetMapping
    public List<Region> getAllRegions() {
        return regionService.listAllRegions();
    }

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable Long id) {
        return regionService.getRegionById(id);
    }

    @GetMapping("/{id}/remove")
    public void removeRegion(@PathVariable Long id) throws Exception {
        regionService.removeRegion(id);
    }
}
