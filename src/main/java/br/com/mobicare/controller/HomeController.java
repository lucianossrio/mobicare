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
public class HomeController {
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
}