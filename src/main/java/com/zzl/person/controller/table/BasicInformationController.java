package com.zzl.person.controller.table;

import com.alibaba.fastjson.JSONObject;
import com.zzl.person.bean.MEmployee;
import com.zzl.person.service.BasicInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class BasicInformationController {

    @Autowired
    BasicInformationService basicInformationService;

    @GetMapping("/table/basic_information")
    public String basic_information(@RequestParam(value = "empNo", defaultValue = "1") String empNo, Model model) {

        MEmployee employee = basicInformationService.getMEmployeeByEmpNo(empNo);

        model.addAttribute("employee", employee);

        return "table/basic_information";
    }

    @PostMapping("/table/updateInformation")
    public String update_information(@RequestBody Map<String, Object> params, HttpSession session) {
        String temporary = params.get("data").toString().substring(1, params.get("data").toString().length() - 1);
        String data = "{" + temporary + "}";
        MEmployee employee = JSONObject.parseObject(data, MEmployee.class);
        String loginUser = (session.getAttribute("loginUser")).toString();
        employee.setUpdShaCd(loginUser);
        basicInformationService.updateById(employee);

        //basicInformationService.updateEmployee(empNo, field, attributes);
        return "redirect:/table/basic_information";
    }

    @ResponseBody
    @GetMapping("/table/searchEmployeeByEmpNo")
    public MEmployee searchEmployeeByEmpNo(@RequestParam("empNo") String empNo) {
        return basicInformationService.getById(empNo);
    }

    @ResponseBody
    @GetMapping("table/searchEmployeeByEmpNameKanji")
    public List<MEmployee> searchEmployeeByEmpNameKanji(@RequestParam("empNameKanji") String empNameKanji) {
        List<MEmployee> employees = basicInformationService.searchEmployeeByEmpNameKanji(empNameKanji);
        if (employees != null && employees.size() > 0) {
            return employees;
        }
        return null;
    }
}
