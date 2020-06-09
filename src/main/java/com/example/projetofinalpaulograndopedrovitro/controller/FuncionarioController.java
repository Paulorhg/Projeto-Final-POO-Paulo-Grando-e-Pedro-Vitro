package com.example.projetofinalpaulograndopedrovitro.controller;

import java.util.List;

import com.example.projetofinalpaulograndopedrovitro.entity.Funcionario;
import com.example.projetofinalpaulograndopedrovitro.entity.Servico;
import com.example.projetofinalpaulograndopedrovitro.service.FuncionarioService;
import com.example.projetofinalpaulograndopedrovitro.service.ServicoService;

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

    @Autowired
    private ServicoService servicoService;

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

        ModelAndView mv = new ModelAndView("detalheFuncionario");

        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        mv.addObject("funcionario", funcionario);
        mv.addObject("horarios", funcionario.getHorarios());
        List<Servico> servicos = servicoService.getServicos();
        servicos.removeAll(funcionario.getServicos());
        mv.addObject("servicos", servicos);

        return mv;

    }

    @GetMapping("/editarFuncionario/{id}")
    public ModelAndView editarFuncionario(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("funcionarioEdit");

        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        mv.addObject("funcionario", funcionario);

        List<Servico> servicos = servicoService.getServicos();
        servicos.removeAll(funcionario.getServicos());

        mv.addObject("servicos", servicos);

        return mv;

    }

    @PostMapping("/associarFuncionarioServico")
    public String associarAutor(@ModelAttribute Servico servico, @RequestParam Integer codigoFuncionario) {
        

        Funcionario funcionario = funcionarioService.getFuncionarioById(codigoFuncionario);
        servico = servicoService.getServicoById(servico.getId());
        

        funcionario.getServicos().add(servico);
        funcionarioService.salvar(funcionario);

        return "redirect:/detalheFuncionario/" + codigoFuncionario;
    }

    @PostMapping("/salvarFuncionario")
    public String salvar(@ModelAttribute Funcionario funcionario) {

        funcionarioService.salvar(funcionario);

        return "redirect:/funcionarios";
    }
}