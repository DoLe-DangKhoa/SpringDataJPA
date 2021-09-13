package com.example.demospringdatajpa.reponsitory;


import com.example.demospringdatajpa.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentReponsitory extends CrudRepository<Student,Long> {
    @Transactional
    @Modifying
    @Query("update Student s set s.email=?2 where s.id=?1")
    public void update(Long id, String email);
}
