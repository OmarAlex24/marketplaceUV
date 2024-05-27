package com.omar.restapicrud.service.interfaces;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface iServiceCategory <T>{
    public T createCategory(@RequestBody T t);
    public T getCategoryById(@PathVariable Long id);
    public List<T> listAllCategories ();
    public void removeCategory(@PathVariable Long id) throws Exception;
}
