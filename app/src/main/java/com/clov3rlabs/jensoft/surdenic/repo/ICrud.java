package com.clov3rlabs.jensoft.surdenic.repo;

import java.util.List;

/**
 * Created by rsaavedra on 23/7/2018.
 */

public interface ICrud {

    public int create(Object item);
    //public int update(Object item);
    //public int delete(Object item);
    public Object findById(Integer id);
    public List<?> findAll();
    public void deleteAll();

}
