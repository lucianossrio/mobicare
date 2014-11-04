package br.com.mobicare.controller;

import java.util.List;








import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mobicare.dao.DepartamentoDAO;
import br.com.mobicare.dao.EmpregadoDAO;
import br.com.mobicare.modelo.Departamento;
import br.com.mobicare.modelo.Empregado;

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
	
	@Transactional
	@RequestMapping("/adicionarEmpregado")
	public String adicionarEmpregado(@Valid Empregado empregado, BindingResult result){
		
		if(result.hasErrors()){
			System.out.println(result.getErrorCount());
		}
		EmpregadoDAO empregadoDAO = appContext.getBean(EmpregadoDAO.class);
		empregadoDAO.salvar(empregado);
		return "home";
	}
	
	@Transactional
	@RequestMapping("/listarEmpregados")
	public ModelAndView listarEmpregados(){
		ModelAndView mv = new ModelAndView("empregado/lista");
		
		EmpregadoDAO empregadoDAO = appContext.getBean(EmpregadoDAO.class);
		List<Empregado> empregados = empregadoDAO.todosOsEmpregados();
		
		mv.addObject("empregados", empregados);
		return mv;
	}
}