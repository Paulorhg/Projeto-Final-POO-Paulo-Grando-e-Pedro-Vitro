package com.example.projetofinalpaulograndopedrovitro.controller;

import com.example.projetofinalpaulograndopedrovitro.entity.Cliente;
import com.example.projetofinalpaulograndopedrovitro.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ModelAndView getClientes() {
        ModelAndView mv = new ModelAndView("clientesTemplate");

        mv.addObject("cliente", new Cliente());
        mv.addObject("clientes", clienteService.getClientes());

        return mv;
    }

    @GetMapping("/removerCliente")
    public String removerCliente(@RequestParam Integer id) {

        Cliente cliente = clienteService.getClienteById(id);
        clienteService.remover(cliente);

        return "redirect:/clientes";
    }

    @GetMapping("/detalheCliente/{id}")
    public ModelAndView detalheCliente(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("detalheCliente");

        Cliente cliente = clienteService.getClienteById(id);
        mv.addObject("cliente", cliente);
        mv.addObject("horarios", cliente.getHorarios());

        return mv;

    }

    @GetMapping("/editarCliente/{id}")
    public ModelAndView editarCliente(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("clienteEdit");

        Cliente cliente = clienteService.getClienteById(id);
        mv.addObject("cliente", cliente);

        return mv;

    }

    @PostMapping("/salvarCliente")
    public String salvar(@ModelAttribute Cliente cliente) {

        clienteService.salvar(cliente);

        return "redirect:/clientes";
    }
}