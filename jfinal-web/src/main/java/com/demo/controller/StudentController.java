package com.demo.controller;

import java.util.List;


import com.demo.Validator.StudentValidator;
import com.demo.model.Student;
import com.demo.service.StudentService;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author  chenshuzhuo
 */
public class StudentController extends Controller {

    
    static StudentService service = new StudentService();

    public void index() {
        render("/index.jsp");
    }
    
    public void add() {
        render("/add.jsp");
    }

    /**
     * @ActionKey的使用
     * 没使用  访问地址 /student/test
     * 使用后  /test
     */
    @ActionKey("/test")
    public void test() {
        List<Student> students = Student.dao.find("select * from student");
        renderJson(students);
    }

    @Before(StudentValidator.class)
    public void save() {
        getModel(Student.class).save();
        redirect("/student/index.jsp");
    }

    public void delete() {
        // 获取表单域名为studentid的值
        boolean id = Student.dao.deleteById(getPara("id"));
        System.out.println(id);
        forwardAction("/student");
    }

    public void del(){
        try {
            Integer paraToInt = getParaToInt();
            Student.dao.deleteById(paraToInt);
            forwardAction("/student");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit() {
        Student student = Student.dao.findById(getPara("id"));
        setAttr("id", student.get("id"));
        setAttr("name", student.get("name"));
        setAttr("age", student.get("age"));
        render("/edit.jsp");
    }

    public void update() {
        try {
            Student student = getModel(Student.class);
            boolean update = student.update();
            System.out.println("更新状态:"+update);
            forwardAction("/student");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}