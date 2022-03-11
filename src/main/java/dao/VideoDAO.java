package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Video;
import utils.JPAUtil;

public class VideoDAO {
	private EntityManager em;
	
	public VideoDAO() {
		this.em = JPAUtil.getEntityManager();
	}
	
	public List<Video> getVideoAll(){
		String jpql = "select v from Video v";
		TypedQuery<Video> query = this.em.createQuery(jpql, Video.class);
		List<Video> list = query.getResultList();
		return list;
	}
	
	public List<Video> getTenVideo(){
		String jpql = "select v from Video v";
		TypedQuery<Video> query = this.em.createQuery(jpql, Video.class);
		query.setMaxResults(10);
		List<Video> list = query.getResultList();
		return list;
	}
	
	public Video findVideoById(int id) {
		Video v = this.em.find(Video.class, id);
		return v;
	}
	
	public void insert(Video v) {
		try {
			this.em.getTransaction().begin();
			
			this.em.merge(v);
			
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void delete(Video v) {
		try {
			this.em.getTransaction().begin();
			this.em.remove(v);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void update(Video v) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(v);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	
	
}
