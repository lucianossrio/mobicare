package br.com.mobicare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.mobicare.modelo.Empregado;

public class EmpregadoDAO {

	private EntityManager manager;
	
	public EmpregadoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void salvar(Empregado empregado) {
		if (empregado.getId() != null) {
			this.manager.persist(empregado);
		} else {
			this.manager.merge(empregado);
		}

	}

	public List<Empregado> todosOsEmpregados() {
		try {
			return this.manager.createQuery("select e from Empregado e",
					Empregado.class).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Empregado buscarEmpregadoPorId(Integer id) {
		try {
			return this.manager
					.createQuery(
							"select e from Empregado e where e.id = :id",
							Empregado.class)
					.setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void deletar(Empregado empregado) {
		this.manager.remove(empregado);
		
	}
}