package com.jpacourse.persistance.dao;

import com.jpacourse.service.VisitService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Transactional
    @Test
    public void testShouldFindAllVisitsByPatientId() {
        // given

        // when

        // then

    }
}
