package com.global.jpa;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="CoffeeOrder")
@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED)
public class CoffeeOrder {

	@Id
	@Column(updatable = false, nullable = false, length = 36)
	private String id;
	
	@PrePersist
	public void generatedId() {
		if (this.id == null) {
			this.id = UUID.randomUUID().toString();
		}
	}
	
	@Column(nullable = false, length = 50)
	private String coffeeName;
	
	@Column(nullable = false)
	private int price;
	
	
	public static CoffeeOrder create(
			String coffeeName
			,int price
			) {
		CoffeeOrder coffeeOrder = new CoffeeOrder();
		coffeeOrder.coffeeName = coffeeName;
		coffeeOrder.price = price;
		return coffeeOrder;
	}
}
