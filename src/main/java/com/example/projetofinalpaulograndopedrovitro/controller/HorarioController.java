package com.example.projetofinalpaulograndopedrovitro.controller;

import com.example.projetofinalpaulograndopedrovitro.entity.Horario;
import com.example.projetofinalpaulograndopedrovitro.service.ClienteService;
import com.example.projetofinalpaulograndopedrovitro.service.FuncionarioService;
import com.example.projetofinalpaulograndopedrovitro.service.HorarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ClienteService clienteService; 

    @GetMapping("/horarios")
    public ModelAndView getHorarios() {
        ModelAndView mv = new ModelAndView("horarioTemplate");

        mv.addObject("horario", new Horario());
        mv.addObject("horarios", horarioService.getHorarios());
        mv.addObject("funcionarios", funcionarioService.getFuncionarios());
        mv.addObject("clientes", clienteService.getClientes());

        return mv;
    }

    @GetMapping("/removerHorario")
    public String removerHorario(@RequestParam Integer id) {

        Horario horario = horarioService.getHorarioById(id);
        horarioService.remover(horario);

        return "redirect:/horarios";
    }

    @GetMapping("/detalheHorario/{id}")
    public ModelAndView detalheHorario(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("detalheHorario");

        Horario horario = horarioService.getHorarioById(id);
        mv.addObject("horario", horario);
        mv.addObject("funcionario", horario.getFuncionario());
        mv.addObject("cliente", horario.getCliente());
        mv.addObject("serviço", horario.getServico());

        return mv;

    }

    @GetMapping("/editarhorario/{id}")
    public ModelAndView editarHorario(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("horarioEdit");

        Horario horario = horarioService.getHorarioById(id);
        mv.addObject("horario", horario);

        return mv;

    }

    @PostMapping("/salvarHorario")
    public String salvar(@ModelAttribute Horario horario) {

        horarioService.salvar(horario);

        return "redirect:/horarios";
    }
}