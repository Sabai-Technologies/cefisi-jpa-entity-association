package fr.sabai.cefisi.onlinebids.domain.onetomany;

import fr.sabai.cefisi.onlinebids.config.InitDBConfig;
import fr.sabai.cefisi.onlinebids.config.JpaTestConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaTestConfig.class, InitDBConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class Item2Test {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

}
