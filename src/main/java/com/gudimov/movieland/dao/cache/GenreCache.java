package com.gudimov.movieland.dao.cache;

import com.gudimov.movieland.dao.GenreDao;
import com.gudimov.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository()
@Primary
public class GenreCache implements GenreDao {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    GenreDao jdbcGenreDao;

    private volatile List<Genre> genreCacheList;

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
    public void invalidate() {
        LOG.info("Start genre cache invalidate");
        List<Genre> genreList = new ArrayList<>();
        List<Genre> genres = jdbcGenreDao.getAll();
        for (Genre genre : genres) {
            genreList.add(genre);
        }
        genreCacheList = genreList;
        LOG.info("Finish genre cache invalidate");
    }

    @Scheduled(cron = "${cache.genre.refresh.interval}")
    private void putOnSchedule() {
        invalidate();
    }

}
