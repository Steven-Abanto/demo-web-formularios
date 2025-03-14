package pe.edu.idat.demo_web_formularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.demo_web_formularios.model.ImcModel;

@Controller
public class ImcController {
    @GetMapping("/imc")
    public String formularioImc(Model model){
        model.addAttribute("imcmodel", new ImcModel());
        return "imc";
    }
    @PostMapping("/calcularimc")
    public String calcuarImc(@ModelAttribute("imcmodel") ImcModel imc, Model model){
        return "imc";
    }
}
