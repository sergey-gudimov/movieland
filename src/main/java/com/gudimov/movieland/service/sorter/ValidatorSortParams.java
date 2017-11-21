package com.gudimov.movieland.service.sorter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ValidatorSortParams {
    private final Logger LOG = LoggerFactory.getLogger(getClass()) ;

    public void validate(String ratingSort, String priceSort) {
        LOG.info("Start validate sort parameters value rating = {} and price = {}", ratingSort, priceSort);
        if (String.valueOf(ratingSort)!= "null"
                && String.valueOf(priceSort) != "null") {
            throw new RuntimeException("Sort parameters exception. Only one of parameter should be set");
        }
        if (String.valueOf(ratingSort) != "null"
                && !SortOrder.DESC.name().equalsIgnoreCase(String.valueOf(ratingSort))) {
            throw new RuntimeException("Sort parameters exception. Illegal parameter rating value");
        }
        if (String.valueOf(priceSort) != "null" &&
                !(SortOrder.ACS.name().equalsIgnoreCase(String.valueOf(priceSort))
                        || SortOrder.DESC.name().equalsIgnoreCase(String.valueOf(priceSort)))) {
            throw new RuntimeException("Sort parameters exception. Illegal parameter rating value");
        }
        LOG.info("Finish validate sort parameters value");
    }
}
