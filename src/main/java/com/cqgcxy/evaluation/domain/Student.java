package com.cqgcxy.evaluation.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * 学生的实体类
 */
@Entity
public class Student implements Serializable {
    @Id    //主键   唯一标识符
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增长
    private Long stu_id;

    @Column(nullable = false)  //非空    账号
    private Integer stu_num;

    @Column(nullable = false)  //非空  密码
    private String stu_psd;

    @Column(nullable = false)  //非空  邮箱
    private String stu_email;



    private String stu_class_id; //班级id

    private String stu_class_str; //班级名称



    public String getStu_class_id() {
        return stu_class_id;
    }

    public void setStu_class_id(String stu_class_id) {
        this.stu_class_id = stu_class_id;
    }

    public Long getStu_id() {
        return stu_id;
    }

    public void setStu_id(Long stu_id) {
        this.stu_id = stu_id;
    }

    public Integer getStu_num() {
        return stu_num;
    }

    public void setStu_num(Integer stu_num) {
        this.stu_num = stu_num;
    }

    public String getStu_psd() {
        return stu_psd;
    }

    public void setStu_psd(String stu_psd) {
        this.stu_psd = stu_psd;
    }

    public String getStu_email() {
        return stu_email;
    }

    public void setStu_email(String stu_email) {
        this.stu_email = stu_email;
    }
}
