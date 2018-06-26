package com.myprojects.spring5.examples.repositories.reactive;

import com.myprojects.spring5.examples.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

    @Autowired
    CatergoryReactiveRepository catergoryReactiveRepository;

    @Before
    public void setUp() throws Exception {
        catergoryReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSave() throws Exception {
        Category category = new Category();
        category.setDescription("Foo");

        catergoryReactiveRepository.save(category).block();
        Long count = catergoryReactiveRepository.count().block();
        assertEquals(Long.valueOf(1L), count);
    }


    @Test
    public void testFindByDescription() throws Exception {
        Category category = new Category();
        category.setDescription("Foo");

        catergoryReactiveRepository.save(category).then().block();

        Category fetchedCat = catergoryReactiveRepository.findByDescription("Foo").block();
        assertNotNull(fetchedCat.getId());
    }
}
