package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Favorite;
import model.User;
import model.Video;
import utils.JPAUtil;

public class UserDAO {
	private EntityManager em;
	
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		User u = userDAO.findById(1);
		List<Favorite> list =  u.getFavorites();
		for (Favorite f : list) {
			System.out.println(f.toString());
		}
	}
	
	
	
	public UserDAO() {
		this.em = JPAUtil.getEntityManager();
	}
	
	public List<User> getUserAll(){
		String jpql = "select u from User u";
		TypedQuery<User> query = this.em.createQuery(jpql, User.class);
		List<User> list = query.getResultList();
		return list;
	}
	
	public User getUser2(String email, String password) {
		String hql = "select u from User u where u.email = :email and u.password = :password";
		TypedQuery<User> query = this.em.createQuery(hql, User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			User u = query.getSingleResult(); 
			return u;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findEmail(String email) {
		String hql = "select u from User u where u.email = :email";
		TypedQuery<User> query = this.em.createQuery(hql, User.class);
		query.setParameter("email", email);
		try {
			User u = query.getSingleResult();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findById(int id) {
		String hql = "select u from User u where u.id = :id";
		TypedQuery<User> query = this.em.createQuery(hql, User.class);
		query.setParameter("id", id);
		try {
			User u = query.getSingleResult();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(User user) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(user);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void update(User user) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(user);
			this.em.getTransaction().commit();
		}catch(Exception e) {
			this.em.getTransaction().rollback();
		}
	}
	
	public void delete(User user) {
		try {
			this.em.getTransaction().begin();
			this.em.remove(user);
			this.em.getTransaction().commit();
		}catch(Exception e) {
			this.em.getTransaction().rollback();
		}
	}
	
	public List<User> getTenUser(){
		String jpql = "select u from User u";
		TypedQuery<User> query = this.em.createQuery(jpql, User.class);
		query.setMaxResults(10);
		List<User> list = query.getResultList();
		return list;
	}
	
	
}
