package com.cqgcxy.evaluation.dao;

import com.cqgcxy.evaluation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * 学生的dao层
 */
@Repository
public interface StudentDao extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {

    /**
     * 根据账号查询学生
     * @param num
     * @return
     */
    @Query(value="from Student where stu_num = ?1")
    public Student findByNum(Integer num);



}
