package com.gudimov.movieland.service.sorter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidatorSortParams {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    public void validate(Optional<SortOrder> sortOrderRating, Optional<SortOrder> sortOrderPrice) {
        LOG.info("Start validate sort parameters value rating = {} and price = {}",
                sortOrderRating, sortOrderPrice);
        if (sortOrderRating.isPresent() && sortOrderPrice.isPresent()) {
            throw new RuntimeException("Sort parameters exception. Only one of parameter should be set");
        }
        if (sortOrderRating.equals(Optional.of(SortOrder.ACS))) {
            //noinspection ConstantConditions
            throw new RuntimeException("Sort parameters exception. Illegal parameter rating sort direction "
                    + sortOrderRating.get().name() + ". Only sort direction " + SortOrder.DESC.name() + " implememnted");
        }
        LOG.info("Finish validate sort parameters value");
    }
}
