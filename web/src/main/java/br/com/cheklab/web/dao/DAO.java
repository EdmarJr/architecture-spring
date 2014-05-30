package br.com.cheklab.web.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.utils.StringUtils;

public abstract class DAO<T> {
	@PersistenceContext
	private EntityManager entityManager;

	Class<T> clazz;

	public DAO() {
		clazz = getEntidade();
	}

	protected Session obterSessao() {
		Session session = (Session) entityManager.getDelegate();
		return session;
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional(readOnly = true)
	public T buscarPorId(Long id) {
		Criteria criteria = obterSessao().createCriteria(clazz);
		criteria.add(Restrictions.eq("id", id));
		return (T) criteria.uniqueResult();
	}

	public void excluir(T entidade) {
		entityManager.remove(entidade);
	}

	public void incluir(T entidade) {
		entityManager.persist(entidade);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> filtrar(T entidade) {
		Criteria criteria = obterSessao().createCriteria(clazz);
		Field[] fields = entidade.getClass().getDeclaredFields();
		for(Field field : fields) {
			String nameField = field.getName();
			StringBuilder sb = new StringBuilder("get");
			sb.append(StringUtils.primeiraLetraMaiuscula(nameField));
			Object retornoGet = null;
			try {
				Method methodGet = entidade.getClass().getMethod(sb.toString());
				if (methodGet != null) {
					retornoGet = methodGet.invoke(entidade);
				}
			} catch (NoSuchMethodException | SecurityException
					| IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (retornoGet != null) {
				criteria.add(Restrictions.eq(nameField, retornoGet));
			}
		}

		return criteria.list();
	}



	public void alterar(T entidade) {
		entityManager.merge(entidade);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> obterTodos() {
		Session session = obterSessao();
		Criteria criteria = session.createCriteria(clazz);
		List<T> list = criteria.list();
		return list;
	}

	public abstract Class<T> getEntidade();

}
