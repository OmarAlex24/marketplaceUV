package com.omar.restapicrud.service.interfaces;

import com.omar.restapicrud.dto.PostDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface iServicePost<T> {
    public T createPost(@RequestBody PostDTO t);
    public List<T> createPosts(@RequestBody List<PostDTO> t);
    public void togglePostVisibility(@RequestBody Long id);
    public T getPostById(@PathVariable Long id);
    public List<T> listAllPosts ();
    public List<T> listAllPostsByUserId(@PathVariable Long id);
    public void removePost(@PathVariable Long id) throws Exception;
}
