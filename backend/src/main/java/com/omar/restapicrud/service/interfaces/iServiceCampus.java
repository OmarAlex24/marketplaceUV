package com.omar.restapicrud.service.interfaces;

import com.omar.restapicrud.dto.CampusDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface iServiceCampus <T>{
    public T createCampus(@RequestBody CampusDTO t);
    public T getCampusById(@PathVariable Long id);
    public List<T> listAllCampuses ();
    public void removeCampus(@PathVariable Long id) throws Exception;
}
