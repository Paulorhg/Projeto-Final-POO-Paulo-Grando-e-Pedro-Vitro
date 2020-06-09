package com.example.projetofinalpaulograndopedrovitro.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        Date dataAtual = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataString = dateFormat.format(dataAtual);

        mv.addObject("dataString", dataString);

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
        mv.addObject("servicos", horario.getFuncionario().getServicos());
        

        List<Integer> horasDisp = new ArrayList<Integer>();

        for (int i = 8; i <= 18; i++){
            horasDisp.add(i);
        }

        List<Integer> horasOcupadas = new ArrayList<Integer>();

        for (Horario hora : horario.getFuncionario().getHorarios()) {
            if(hora.getData().equals(horario.getData()) ){
                horasOcupadas.add(hora.getHora());
            }
        }

        for (Horario hora : horario.getCliente().getHorarios()) {
            if(hora.getData().equals(horario.getData())){
                horasOcupadas.add(hora.getHora());
            }
        }

        horasDisp.removeAll(horasOcupadas);

        mv.addObject("horasDisp", horasDisp);

        return mv;

    }

    @GetMapping("/editarHorario/{id}")
    public ModelAndView editarHorario(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("horarioEdit");

        Horario horario = horarioService.getHorarioById(id);
        mv.addObject("horario", horario);
        mv.addObject("clienteAtual", horario.getCliente());
        mv.addObject("funcionarioAtual", horario.getFuncionario());
        mv.addObject("clientes", clienteService.getClientes());
        mv.addObject("funcionarios", funcionarioService.getFuncionarios());

        return mv;

    }

    @PostMapping("/salvarHorario")
    public String salvar(@ModelAttribute Horario horario) {

        horarioService.salvar(horario);

        return "redirect:/horarios";
    }
}