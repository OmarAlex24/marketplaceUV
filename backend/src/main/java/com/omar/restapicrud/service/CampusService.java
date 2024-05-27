package com.omar.restapicrud.service;

import com.omar.restapicrud.dto.CampusDTO;
import com.omar.restapicrud.model.Campus;
import com.omar.restapicrud.model.Region;
import com.omar.restapicrud.repository.CampusRepository;
import com.omar.restapicrud.repository.RegionRepository;
import com.omar.restapicrud.service.interfaces.iServiceCampus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CampusService implements iServiceCampus<Campus> {
    @Autowired
    CampusRepository campusRepository;

    RegionRepository regionRepository;

    @Override
    public Campus createCampus(CampusDTO campus) {
        if (!campusRepository.existsByCampusNameIgnoreCase(campus.getCampusName())) {
            Region region = regionRepository.findById(campus.getCampusRegionId()).get();

            Campus nuevoCampus = new Campus(campus.getCampusId(), campus.getCampusName(), region);

            return campusRepository.save(nuevoCampus);
        }
        throw new ResponseStatusException(
                HttpStatus.CONFLICT, "Ya existe un campus con ese nombre");
    }

    @Override
    public Campus getCampusById(Long id) {
        if(campusRepository.existsById(id)){
            return campusRepository.findById(id).get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existe el campus a consultar");
    }

    @Override
    public List<Campus> listAllCampuses() {
        return campusRepository.findAll();
    }

    @Override
    public void removeCampus(Long id) throws Exception {
        if(campusRepository.existsById(id)){
            campusRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe el campus a eliminar");
        }
    }
}
