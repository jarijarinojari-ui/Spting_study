package com.global.rest.domainAnime;

import com.global.rest.domain.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "animes")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Anime extends BaseEntity{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable= false, unique = true )
		private String title;
		
		@Column(nullable = false)
		@Min(1)
		@Max(10)
		private Integer rate;
		
		public static Anime create(String title, Integer rate) {
			Anime anime = new Anime();
			anime.title=title;
			anime.rate=rate;
			return anime;
		}
		
		public void update(Integer rate) {this.rate=rate;}
}
