package br.com.mobicare.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mobicare.dao.DepartamentoDAO;
import br.com.mobicare.modelo.Departamento;
import br.com.mobicare.util.JPAUtil;

@Controller
public class EmpregadoController {
	
	@RequestMapping("/novoEmpregado")
	public ModelAndView novoEmpregado(){
		ModelAndView mv = new ModelAndView("empregado/formulario");
		
		DepartamentoDAO departamentoDAO = new DepartamentoDAO(JPAUtil.getEntityManager());
		List<Departamento> departamentos = departamentoDAO.todosOsDepartamentos();
		
		mv.addObject("departamentos", departamentos);
		return mv;
	}
}