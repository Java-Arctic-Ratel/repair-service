package com.epam.repair.rest_app;

import com.epam.repair.model.Street;
import java.util.List;

/**
 * Street Service Interface.
 */
public interface StreetService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Street> findAll();
}
