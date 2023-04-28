package com.jujubaprojects.alunojr.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.alunojr.model.AlunoJr;

@Controller
public class AlunoJrController {

    List<AlunoJr> alunos = new ArrayList<>();

    @GetMapping("/home")
    public String home(){
       return "home";
    }

    @PostMapping("/home")
    public String lista(AlunoJr aluno){
      int matricula = alunos.size() +1;
      alunos.add(new AlunoJr(matricula,aluno.getNome(),aluno.getCurso()
      ,aluno.getNota1(),aluno.getNota2(),aluno.getNota3()));
      return "redirect:lista";

    }

    @GetMapping("/lista")
    public ModelAndView lista(){
       ModelAndView mv = new ModelAndView("lista");
       mv.addObject("alunos", alunos);
       return mv;    
    

    }
    }
