package pe.edu.idat.demo_web_formularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.demo_web_formularios.model.CalcModel;

@Controller
public class CalcController {
        @GetMapping("/calcnota")
        public String formularioNota(Model model){
            model.addAttribute("calcmodel", new CalcModel());
            model.addAttribute("visualizarprom", false);
            return "calcnota";
        }
        @PostMapping("/calcularnota")
        public String calcuarNota(@ModelAttribute("calcmodel") CalcModel calcnota, Model model){
            Double nota1 = calcnota.getNota1()*0.04;
            Double nota2 = calcnota.getNota2()*0.12;
            Double nota3 = calcnota.getNota3()*0.24;
            Double notaFin = calcnota.getNotaFin()*0.60;
            Double promedio = (nota1 + nota2 + nota3 + notaFin);

            String diagnostico = "", estiloDiagnostico= "alert-danger";

            if (promedio < 13){
                diagnostico = "Desaprobado";
            } else {
                diagnostico = "Aprobado";
                estiloDiagnostico = "alert-primary";
            }
            model.addAttribute("Resultado","Su promedio= " + String.format("%.2f",promedio) +
                    ", usted se encuentra: "+ diagnostico);
            model.addAttribute("visualizarprom", true);
            model.addAttribute("estilodiagnostico", estiloDiagnostico);
            return "calcnota";
        }
    }
