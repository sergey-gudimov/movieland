package com.gudimov.movieland.service.sorter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ValidatorSortParams {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    public void validate(SortOrder sortOrderRating, SortOrder sortOrderPrice) {
        LOG.info("Start validate sort parameters value rating = {} and price = {}",
                sortOrderRating, sortOrderPrice);
        if (sortOrderRating != null && sortOrderPrice != null) {
            throw new RuntimeException("Sort parameters exception. Only one of parameter should be set");
        }
        if (sortOrderRating != null && !sortOrderRating.equals(SortOrder.DESC)) {
            throw new RuntimeException("Sort parameters exception. Illegal parameter rating sort direction "
                    + sortOrderRating.name() + ". Only sort direction " + SortOrder.DESC.name() + " implememnted");
        }
        LOG.info("Finish validate sort parameters value");
    }
}
