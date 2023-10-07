package test.vn.test7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import test.vn.test7.entity.EmployeeEntity;
import test.vn.test7.service.EmpService;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String index(Model m) {
        List<EmployeeEntity> list = empService.getAllEmp();
        m.addAttribute("empList", list);
        return "index";
    }

    @GetMapping("/loadEmpSave")
    public String loadEmpSave() {
        return "emp_save";
    }

    @GetMapping("/EditEmp/{id}")
    public String EditEmp(@PathVariable int id, Model m) {
        // System.out.println(id);
        EmployeeEntity emp = empService.getEmpById(id);
        m.addAttribute("emp", emp);
        return "edit_emp";
    }

    @PostMapping("/saveEmp")
    public String saveEmp(@ModelAttribute EmployeeEntity emp, HttpSession session) {
        // System.out.println(emp);

        EmployeeEntity newEmp = empService.saveEmp(emp);

        if (newEmp != null) {
            // System.out.println("save success");
            session.setAttribute("msg", "Register sucessfully");
        } else {
            // System.out.println("something wrong on server");
            session.setAttribute("msg", "something wrong on server");
        }

        return "redirect:/loadEmpSave";
    }

    @PostMapping("/updateEmpDtls")
    public String updateEmp(@ModelAttribute EmployeeEntity emp, HttpSession session) {
        // System.out.println(emp);

        EmployeeEntity updateEmp = empService.saveEmp(emp);

        if (updateEmp != null) {
            // System.out.println("save success");
            session.setAttribute("msg", "Update sucessfully");
        } else {
            // System.out.println("something wrong on server");
            session.setAttribute("msg", "something wrong on server");
        }

        return "redirect:/";
    }

    @GetMapping("/deleteEmp/{id}")
    public String loadEmpSave(@PathVariable int id, HttpSession session) {
        boolean f = empService.deleteEmp(id);
        if (f) {
            session.setAttribute("msg", "Delete sucessfully");
        } else {
            session.setAttribute("msg", "something wrong on server");
        }
        return "redirect:/";
    }

}
