package br.edu.ifal.listar_compras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListaComprasController{

    @Autowired
    ListaComprasRepository listaRepo;

    Item item = new Item();

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/listacompras")
    public String listarCompras() {
        ModelAndView mv = new ModelAndView();
        Iterable<Item> itens = listaRepo.findAll();
        mv.addObject("itens", itens);
        return "listacompras";
    }

    @RequestMapping("listacompras/cadastrar")
    public ModelAndView cadastrar(Item item) {
        ModelAndView mv = new ModelAndView("redirect:/listacompras");
        listaRepo.save(item);
        return mv;
    }
    @RequestMapping("/excluir/{id}")
    public ModelAndView excluirItem(@PathVariable(name = "id") Long id) {
        ModelAndView mv = new ModelAndView("redirect: /listacompras/");
        listaRepo.deleteById(id);
        return mv;
    }
}