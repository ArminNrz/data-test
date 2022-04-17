package com.example.datatest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ServiceTest {

    private final EntityManager entityManager;

    private static final String ROW_FORMAT = "\t(%d, '%s')";
    private static final String QUERY_HEAD = "insert into tbl_query_string_builder(code, name) \nVALUES \n";
    public static final String END_OF_ROW = ",\n";

    public void insertByQuery(Long count) {

        Random random = new Random();

        StringBuilder statement = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String row = String.format(ROW_FORMAT, random.nextLong(), "Test-name");

            if (statement.length() == 0) {
                statement.append(QUERY_HEAD);
            }
            else {
                statement.append(END_OF_ROW);
            }

            statement.append(row);
        }

        entityManager.unwrap(Session.class).createNativeQuery(statement.toString()).executeUpdate();
        entityManager.unwrap(Session.class).getSessionFactory().getCache().evictAllRegions();
    }
}
