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
	
	@RequestMapping("/editarEmpregado")
	public ModelAndView editarEmpregado(Empregado empregado){
		ModelAndView mv = new ModelAndView("empregado/formulario");
		
		EmpregadoDAO empregadoDAO = appContext.getBean(EmpregadoDAO.class);
		empregado = empregadoDAO.buscarEmpregadoPorId(empregado.getId());
		
		DepartamentoDAO departamentoDAO = appContext.getBean(DepartamentoDAO.class);
		List<Departamento> departamentos = departamentoDAO.todosOsDepartamentos();
		
		mv.addObject("departamentos", departamentos);
		mv.addObject("empregado", empregado);
		return mv;
	}
	
	@Transactional
	@RequestMapping("/salvarEmpregado")
	public String salvarEmpregado(@Valid Empregado empregado, BindingResult result){
		
		if(result.hasErrors()){
			System.out.println(result.getFieldError().getDefaultMessage());
		}
		EmpregadoDAO empregadoDAO = appContext.getBean(EmpregadoDAO.class);
		
		empregadoDAO.salvar(empregado);
		return "redirect:listarEmpregados";
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
	
	@Transactional
	@RequestMapping("/excluirEmpregado")
	public String excluirEmpregado(Empregado empregado){
		EmpregadoDAO empregadoDAO = appContext.getBean(EmpregadoDAO.class);
		empregado = empregadoDAO.buscarEmpregadoPorId(empregado.getId());
		
		empregadoDAO.deletar(empregado);
		return "redirect:listarEmpregados";
	}
}