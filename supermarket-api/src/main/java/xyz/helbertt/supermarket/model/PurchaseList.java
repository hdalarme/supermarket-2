package xyz.helbertt.supermarket.model;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import xyz.helbertt.supermarket.model.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchase_lists")
public class PurchaseList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false) //, unique = true
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User userId;
	
	//private Timestamp created_at;
	
	//private Timestamp updated_at;
}
