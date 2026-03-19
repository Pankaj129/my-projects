package dao;

import static utils.HibernateUtils.getFactory;

import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.RoleEntity;
import pojos.RoleEnum;

public class RoleDaoImpl implements IRoleDao {

	@Override
	public String addRole(RoleEntity role) {
		String mesg = "Additing new role failed.... ";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(role);
			mesg = "Role added successfully..!!!";
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Set<RoleEntity> getRolesByRoleName(Set<RoleEnum> roles) {
		Set<RoleEntity> roleSet = null;
		String jpql = "select r from RoleEntity r where r.roleName in(rl)";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			roleSet = session.createQuery(jpql, RoleEntity.class).setParameter("rl", roleSet).getResultStream()
					.collect(Collectors.toSet());
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return roleSet;
	}

}
