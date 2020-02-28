package com.elioms.cambioymoneda.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "currency_transference")
public class CurrencyTransference implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
    private String code;

    @Column(name = "currency_value", nullable = false)
    private Float currencyValue;

    @Column(name = "purchase_value", nullable = false)
    private Float purchaseValue;

    @Column(name = "sale_value", nullable = false)
    private Float saleValue;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Currency currency;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Transference transference;
    
    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Float getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(Float currencyValue) {
		this.currencyValue = currencyValue;
	}

	public Float getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(Float purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public Float getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(Float saleValue) {
		this.saleValue = saleValue;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Transference getTransference() {
		return transference;
	}

	public void setTransference(Transference transference) {
		this.transference = transference;
	}
}
