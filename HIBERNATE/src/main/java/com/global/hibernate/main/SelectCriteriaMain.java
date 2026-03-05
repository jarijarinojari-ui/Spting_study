package com.global.hibernate.main;

import java.util.List;

import com.global.hibernate.entity.Music;
import com.global.hibernate.entity.MusicDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public class SelectCriteriaMain {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Music> cq = cb.createQuery(Music.class);
		Root<Music> root = cq.from(Music.class);
		root.fetch("musicDetail", JoinType.INNER);
		cq.select(root);
		
		List<Music> list = em.createQuery(cq).getResultList();

		list.forEach(m -> {
			MusicDetail md = m.getMusicDetail();
			System.out.println("─────────────────────────────");
			System.out.println("MUSIC_NO     : " + m.getMusicNo());
			System.out.println("TITLE        : " + m.getTitle());
			System.out.println("VOCAL        : " + m.getVocal());
			System.out.println("RELEASE_COMP : " + md.getReleaseComp());
			System.out.println("RELEASE_DATE : " + md.getReleaseDate());
			System.out.println("CREATE_DATE  : " + md.getCreateDate());
			System.out.println("─────────────────────────────");
		});
	}
}