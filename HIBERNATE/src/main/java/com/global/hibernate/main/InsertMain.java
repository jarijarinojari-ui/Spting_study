package com.global.hibernate.main;

import java.time.LocalDate;

import com.global.hibernate.entity.Music;
import com.global.hibernate.entity.MusicDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InsertMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Music music1 = new Music();
            music1.setTitle("Dynamite");
            music1.setVocal("BTS");

            MusicDetail detail1 = new MusicDetail();
            detail1.setReleaseComp("빅히트엔터테인먼트");
            detail1.setReleaseDate(LocalDate.of(2020, 8, 21));
            detail1.setMusic(music1);

            em.persist(music1);
            em.persist(detail1);

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}