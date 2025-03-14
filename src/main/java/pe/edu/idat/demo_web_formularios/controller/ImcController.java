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
        model.addAttribute("visualizaralerta", false);
        return "imc";
    }
    @PostMapping("/calcularimc")
    public String calcuarImc(@ModelAttribute("imcmodel") ImcModel imc, Model model){
        Double tallam = imc.getTalla()/100;
        Double valorImc = imc.getPeso()/(tallam * tallam);
        String diagnostico = "", estiloDiagnostico= "alert-danger";

        if (valorImc <= 18.5){
            diagnostico = "Por debajo del peso";
            estiloDiagnostico = "alert-dark";
        } else if (valorImc <= 25) {
            diagnostico = "Con peso normal";
            estiloDiagnostico = "alert-primary";
        } else if (valorImc <= 30) {
            diagnostico = "Con sobrepeso";
            estiloDiagnostico = "alert-warning";
        } else if (valorImc <= 36) {
            diagnostico = "Obesidad leve";
        } else if (valorImc <= 39) {
            diagnostico = "Obesidad media";
        }else{
            diagnostico = "Obesidad mórbida";
        }
        model.addAttribute("Resultado","Su valor IMC = " + String.format("%.2f",valorImc) +
                ", usted se encuentra: "+ diagnostico);
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("estilodiagnostico", estiloDiagnostico);
        return "imc";
    }
}