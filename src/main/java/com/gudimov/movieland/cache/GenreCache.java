package com.gudimov.movieland.cache;

import com.gudimov.movieland.dao.GenreDao;
import com.gudimov.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository()
public class GenreCache {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    GenreDao genreDao;

    private List<Genre> genreCacheList;

    public List<Genre> getAll() {
        LOG.info("Start genre cache get all");
        ArrayList<Genre> genresCopy = new ArrayList<>();
        for (Genre genre : genreCacheList) {
            Genre genreCopy = new Genre();
            genreCopy.setId(genre.getId());
            genreCopy.setName(genre.getName());
            genresCopy.add(genreCopy);
        }
        LOG.info("Finish genre cache get all");
        return genresCopy;
    }

    @PostConstruct()
    @Scheduled(cron = "${cache.genre.refresh.interval}")
    public void invalidate() {
        LOG.info("Start genre cache invalidate");
        clear();
        fill();
        LOG.info("Finish genre cache invalidate");
    }

    private void fill() {
        LOG.info("Start genre cache fill");
        List<Genre> genres = genreDao.getAll();
        for (Genre genre : genres) {
            genreCacheList.add(genre);
        }
        LOG.info("Finish genre cache fill");
    }

    private void clear() {
        LOG.info("Start genre cache get clear");
        genreCacheList = Collections.synchronizedList(new ArrayList<>());
        LOG.info("Finish genre cache get clear");
    }
}
