package com.example.projetofinalpaulograndopedrovitro.controller;

import com.example.projetofinalpaulograndopedrovitro.entity.Servico;
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
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/servicos")
    public ModelAndView getServicos() {
        ModelAndView mv = new ModelAndView("servicoTemplate");

        mv.addObject("servico", new Servico());
        mv.addObject("servicos", servicoService.getServicos());

        return mv;
    }

    @GetMapping("/removerServico")
    public String removerServico(@RequestParam Integer id) {

        Servico servico = servicoService.getServicoById(id);
        servicoService.remover(servico);

        return "redirect:/servicos";
    }

    @GetMapping("/detalheServico/{id}")
    public ModelAndView detalheServico(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("detalheServico");

        Servico servico = servicoService.getServicoById(id);
        mv.addObject("servico", servico);
        mv.addObject("funcionarios", servico.getFuncionarios());

        return mv;

    }

    @GetMapping("/editarServico/{id}")
    public ModelAndView editarServico(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("servicoEdit");

        Servico servico = servicoService.getServicoById(id);
        mv.addObject("servico", servico);

        return mv;

    }

    @PostMapping("/salvarServico")
    public String salvar(@ModelAttribute Servico servico) {

        servicoService.salvar(servico);

        return "redirect:/servicos";
    }
}