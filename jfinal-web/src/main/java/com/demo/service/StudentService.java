package com.demo.service;

import com.demo.model.Student;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

public class StudentService {
    /**
     * 所有的 dao 对象也放在 Service 中
     */
    private static final Student dao = new Student().dao;
    
    public Page<Student> paginate(int pageNumber, int pageSize) {
        return dao.paginate(pageNumber, pageSize, "select *", "from student order by id asc");
    }
    
    public Student findById(int id) {
        return dao.findById(id);
    }
    
    public void deleteById(int id) {
        dao.deleteById(id);
        
    }
    public List<Student> find() {
        
        return dao.find("select * from student order by id asc");
    }
}