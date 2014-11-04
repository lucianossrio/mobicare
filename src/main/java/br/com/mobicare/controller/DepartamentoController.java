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
public class DepartamentoController {
	
	@Autowired
	private ApplicationContext appContext;
	
	@RequestMapping("/novoDepartamento")
	public String novoDepartamento(){
		return "departamento/formulario";
	}
	
	@RequestMapping("/editarDepartamento")
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
	@RequestMapping("/salvarDepartamento")
	public String salvarEmpregado(@Valid Empregado empregado, BindingResult result){
		
		if(result.hasErrors()){
			System.out.println(result.getFieldError().getDefaultMessage());
		}
		EmpregadoDAO empregadoDAO = appContext.getBean(EmpregadoDAO.class);
		
		empregadoDAO.salvar(empregado);
		return "redirect:listarEmpregados";
	}
	
	@Transactional
	@RequestMapping("/listarDepartamentos")
	public ModelAndView listarDepartamentos(){
		ModelAndView mv = new ModelAndView("departamento/lista");
		
		DepartamentoDAO departamentoDAO = appContext.getBean(DepartamentoDAO.class);
		List<Departamento> departamentos = departamentoDAO.todosOsDepartamentos();
		
		mv.addObject("departamentos", departamentos);
		return mv;
	}
	
	@Transactional
	@RequestMapping("/listarDepartamentosVazios")
	public ModelAndView listarDepartamentosVazios(){
		ModelAndView mv = new ModelAndView("departamento/lista");
		
		DepartamentoDAO departamentoDAO = appContext.getBean(DepartamentoDAO.class);
		List<Departamento> departamentos = departamentoDAO.todosOsDepartamentosSemEmpregados();
		
		mv.addObject("departamentos", departamentos);
		return mv;
	}
	
	@Transactional
	@RequestMapping("/excluirDepartamento")
	public String excluirEmpregado(Departamento departamento){
		DepartamentoDAO departamentoDAO = appContext.getBean(DepartamentoDAO.class);
		departamento = departamentoDAO.buscarDepartamentoPorId(departamento.getId());
		
		departamentoDAO.deletar(departamento);
		return "redirect:listarDepartamentos";
	}
}