package com.hy.spring_ssh.connter;

import com.hy.spring_ssh.bean.H_Class;
import com.hy.spring_ssh.bean.H_Student;
import com.hy.spring_ssh.servlce.H_StuServlce;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Controller
//@RequestMapping("/stu")
public class H_StuController {
    @Resource(name = "stuServlce")
    private H_StuServlce stu;

    public H_StuServlce getStu() {
        return stu;
    }

    public void setStu(H_StuServlce stu) {
        this.stu = stu;
    }

    //联合查询H_Student ,H_CLASS
//    @RequestMapping("/queryall.do")
    @GetMapping("item")
    public String Queryall(Model model) {
        model.addAttribute("list", stu.Query());
        model.addAttribute("lis", stu.QueryClass());
        return "/query";
    }

    @RequestMapping("/queryclass.do")
    @ResponseBody
    public List Queryclass() {
        List<H_Class> list = stu.QueryClass();
        return list;
    }

    //数组 参数绑定 批量删除
    @RequestMapping(value = "/jquery.do")
    public String jquery(String[] student) {

        System.out.println("进来了");
        System.out.println(Arrays.toString(student));

        for (String stu1 : student) {
            System.out.println("====" + stu1);
            stu.delect(Integer.valueOf(stu1));
        }
        return "redirect:queryall.do";
    }

    //删除
//    @RequestMapping(value = "/delectsid.do")
    @DeleteMapping("item/{sid}")
    public String delectsid(@PathVariable() Integer sid) {
        System.out.println("+++++++++++++++++++++++++" + sid);
        stu.delect(sid);
        return "redirect:queryall.do";
    }

    //添加学生信息
    @RequestMapping(value = "/addStudent.do")
    public String AddStudent(H_Student student,@RequestParam("filee") MultipartFile mu){
//        设置图片名称不能重复
        String uuidname= UUID.randomUUID().toString();
        System.out.println("UUid++++"+uuidname);
//        获取文件名s
        String  filename=mu.getOriginalFilename();
        System.out.println("UUid++++"+filename);
//        获取文件后缀

        String textname=filename.substring(filename.lastIndexOf("."));

        try {
            mu.transferTo(new File(""+uuidname+textname));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------"+uuidname+textname);
        student.setFile(uuidname+textname);
        stu.setStudent(student);
        return "redirect:item.do";
    }

    //    查询班级信息
    @RequestMapping("/queryH_Class.do")
    public String QueryH_Class(Model model) {
        model.addAttribute("list", stu.QueryClass());
        return "/addstudent";
    }

    @RequestMapping("/getStudentid.do")
    public String getStudentid(Model model, Integer sid) {
        model.addAttribute("list", stu.Setstudent(sid));
        model.addAttribute("lis", stu.QueryClass());
        return "/setstudent";
    }

    @RequestMapping("/queryAndStu.do")
    public String QueryAndStu(Model model, Integer cid, String name, String sex) {
        System.out.println("班级" + cid + "姓名" + name + "性别");
        model.addAttribute("list", stu.QueryStu(cid, name, sex));
        model.addAttribute("lis", stu.QueryClass());
        return "/query";


    }

    @RequestMapping("/login.do")
    public String Login(H_Student student) {
        System.out.println( "姓名" +student.getSname() + "性别"+student.getSage());
         List<H_Student> h_students=stu.Query();
         if(h_students.get(0).getSname()!=student.getSname()){

         }
        return "";

    }


}







