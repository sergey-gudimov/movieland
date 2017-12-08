package com.gudimov.movieland.dao.cache;

import com.gudimov.movieland.dao.CurrencyDao;
import com.gudimov.movieland.service.currency.CurrencyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Map;

@Repository()
@Primary
public class CurrencyCache implements CurrencyDao {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private volatile Map<CurrencyCode, Double> currencyMap;

    @Autowired
    private CurrencyDao jdbcCurrencyDao;

    public Map<CurrencyCode, Double> getAll() {
        LOG.info("Start currency cache get all");
        return currencyMap;
    }

    @PostConstruct()
    public void invalidate() {
        LOG.info("Start currency cache invalidate");
        currencyMap = Collections.unmodifiableMap(jdbcCurrencyDao.getAll());
        LOG.info("Finish currency cache invalidate");
    }

    @Scheduled(cron = "${cache.currency.refresh.interval}")
    private void putOnSchedule() {
        invalidate();
    }

}
