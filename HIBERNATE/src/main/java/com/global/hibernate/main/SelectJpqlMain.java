package com.global.hibernate.main;

import java.util.List;

import com.global.hibernate.entity.Music;
import com.global.hibernate.entity.MusicDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SelectJpqlMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
        EntityManager em = emf.createEntityManager();

        List<Music> list = em.createQuery(
        	    "SELECT m FROM Music m JOIN FETCH m.musicDetail md", Music.class)
        	    .getResultList();

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