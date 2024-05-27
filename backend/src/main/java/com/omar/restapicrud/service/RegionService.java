package com.omar.restapicrud.service;

import com.omar.restapicrud.model.Region;
import com.omar.restapicrud.repository.RegionRepository;
import com.omar.restapicrud.service.interfaces.iServiceRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RegionService implements iServiceRegion<Region> {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public Region createRegion(Region region) {
        if (!regionRepository.existsByRegionNameIgnoreCase(region.getRegionName())) {
            return regionRepository.save(region);
        }
        throw new ResponseStatusException(
                HttpStatus.CONFLICT, "Ya existe una region con ese nombre");
    }

    @Override
    public Region getRegionById(Long id) {
        if(regionRepository.existsById(id)){
            return regionRepository.findById(id).get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existe la region a consultar");
    }

    @Override
    public List<Region> listAllRegions() {
        return regionRepository.findAll();
    }

    @Override
    public void removeRegion(Long id) throws Exception {
        if(regionRepository.existsById(id)){
            regionRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe la region a eliminar");
        }
    }
}
