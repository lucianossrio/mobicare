package br.com.mobicare.controller;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mobicare.dao.DepartamentoDAO;
import br.com.mobicare.dao.EmpregadoDAO;
import br.com.mobicare.modelo.Departamento;
import br.com.mobicare.modelo.Empregado;
import br.com.mobicare.util.JPAUtil;

@Controller
public class EmpregadoController {
	
	@Autowired
	private ApplicationContext appContext;
	
	@RequestMapping("/novoEmpregado")
	public ModelAndView novoEmpregado(){
		ModelAndView mv = new ModelAndView("empregado/formulario");
		
		DepartamentoDAO departamentoDAO = appContext.getBean(DepartamentoDAO.class);
		List<Departamento> departamentos = departamentoDAO.todosOsDepartamentos();
		
		mv.addObject("departamentos", departamentos);
		return mv;
	}
	
	@RequestMapping("/adicionarEmpregado")
	public String adicionarEmpregado(Empregado empregado){
		EmpregadoDAO empregadoDAO = appContext.getBean(EmpregadoDAO.class);
		empregadoDAO.salvar(empregado);
		return "home";
	}
}