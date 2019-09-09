package com.cqgcxy.evaluation.service;

import com.cqgcxy.evaluation.dao.StudentDao;
import com.cqgcxy.evaluation.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    /**
     * 用户登录验证
     * @param num
     * @return
     */
    public  Student findByNum(Integer num){
        return studentDao.findByNum(num);
    }
}
