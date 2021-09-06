package com.zzl.person.controller.table;

import com.zzl.person.bean.MEmployee;
import com.zzl.person.service.MemberManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class MemberManagementController {

    @Autowired
    MemberManagementService managementService;

    @GetMapping("/table/member_management")
    public String member_management(Model model) {

        List<MEmployee> employees = managementService.getAllBase();

        model.addAttribute("employees", employees);
        return "table/member_management";
    }

    @GetMapping("/table/add_employee")
    public String add_employee_form() {

        return "table/add_employee";
    }

    @PostMapping("/table/add")
    public String addEmployee(@RequestBody Map<String, MEmployee> data, HttpSession session) {

        MEmployee employee = data.get("employee");
        employee.setUpdShaCd(session.getAttribute("loginUser").toString());
        employee.setInsShaCd(session.getAttribute("loginUser").toString());
        employee.setDFlag(0);
        managementService.save(employee);
        return "redirect:/table/member_management";
    }
}
