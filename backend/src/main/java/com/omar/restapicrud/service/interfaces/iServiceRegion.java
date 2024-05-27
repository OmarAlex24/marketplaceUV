package com.omar.restapicrud.service.interfaces;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface iServiceRegion <T>{
    public T createRegion(@RequestBody T t);
    public T getRegionById(@PathVariable Long id);
    public List<T> listAllRegions ();
    public void removeRegion(@PathVariable Long id) throws Exception;
}
