package com.nandha.learnings.spring.datajpa.repository;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest /*This will help you to test the repository layer and once the operation is done, it will flush the data.
//               So, the database won't be impacted.'*/
@SpringBootTest //Ideally you should not use this annotation to test the repository layer. But currently, we want the database to be impacted
class StudentRepositoryTest {


}