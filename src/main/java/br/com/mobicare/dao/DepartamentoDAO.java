package br.com.mobicare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.mobicare.modelo.Departamento;
import br.com.mobicare.modelo.Empregado;
import br.com.mobicare.util.JPAUtil;

public class DepartamentoDAO {

	private EntityManager manager;

	public DepartamentoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void salvar(Departamento departamento) {
		if (departamento.getId() == null) {
			this.manager.persist(departamento);
		} else {
			this.manager.merge(departamento);
		}

	}

	public List<Departamento> todosOsDepartamentos() {
		try {
			return this.manager.createQuery("select d from Departamento d",
					Departamento.class).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Departamento buscarDepartamentoPorId(Integer id) {
		try {
			return this.manager
					.createQuery(
							"select d from Departamento d where d.id = :id",
							Departamento.class)
					.setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Departamento> todosOsDepartamentosSemEmpregados() {
		try {
			return this.manager.createQuery(
					"select d from Departamento d where d.empregados IS EMPTY",
					Departamento.class).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void removerDepartamento(Departamento departamento) {
		this.manager.remove(departamento);
	}
}