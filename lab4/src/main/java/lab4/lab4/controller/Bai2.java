package lab4.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

@Controller
public class Bai2 {
    @RequestMapping("/staff/validate/form")
    public String createForm(Model model, @ModelAttribute("staff") Staff staff){
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        model.addAttribute("errors", true);
        return "bai2/staff-validate";
    }

    @RequestMapping("/staff/validate/save")
    public String createSave(Model model, 
                            @RequestPart("photo_file") MultipartFile photoFile,
                            @Valid @ModelAttribute("staff") Staff staff, Errors errors){
        if(!photoFile.isEmpty()){
            staff.setPhoto(photoFile.getName());
        }
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
            model.addAttribute("errors", true); 
        }else{
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
            model.addAttribute("errors", false);
        }
        return "bai2/staff-validate";
    }
}

