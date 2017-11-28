package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.link.LinkMovieGenre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/root-context.xml"})
public class JdbcLinkMovieGenreDaoITest {

    @Autowired
    private JdbcMovieGenreDao jdbcMovieGenreDao;

    @Test
    public void getAll() throws Exception {
        List<LinkMovieGenre> allGenre = jdbcMovieGenreDao.getAll();
        assertNotEquals(allGenre.size(), 0);
    }

}