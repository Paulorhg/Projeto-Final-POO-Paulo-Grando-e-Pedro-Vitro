package com.example.projetofinalpaulograndopedrovitro.controller;

import com.example.projetofinalpaulograndopedrovitro.entity.Funcionario;
import com.example.projetofinalpaulograndopedrovitro.service.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public ModelAndView getFuncionarios() {
        ModelAndView mv = new ModelAndView("funcionariosTemplate");

        mv.addObject("funcionario", new Funcionario());
        mv.addObject("funcionarios", funcionarioService.getFuncionarios());

        return mv;
    }

    @GetMapping("/removerFuncionario")
    public String removerFuncionario(@RequestParam Integer id) {

        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        funcionarioService.remover(funcionario);

        return "redirect:/funcionarios";
    }

    @GetMapping("/detalheFuncionario/{id}")
    public ModelAndView detalheFuncionario(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("detalhefuncionario");

        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        mv.addObject("funcionario", funcionario);
        mv.addObject("horarios", funcionario.getHorarios());
        // mv.addObject("serviços", funcionario.getServiços());

        return mv;

    }

    @GetMapping("/editarFuncionario/{id}")
    public ModelAndView editarFuncionario(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("funcionarioEdit");

        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        mv.addObject("funcionario", funcionario);

        return mv;

    }

    @PostMapping("/salvarFuncionario")
    public String salvar(@ModelAttribute Funcionario funcionario) {

        funcionarioService.salvar(funcionario);

        return "redirect:/funcionarios";
    }
}