package com.elioms.cambioymoneda.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "transferences")
public class Transference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Integer type;

    @NotNull
    @Column(nullable = false, name = "total_amount")
    private Float totalAmount;

    @NotNull
    @Column(nullable = false)
    private String status;

    @Temporal(TemporalType.DATE)
    private Date date;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Column(nullable = false)
    private Integer step;

    @JsonIgnoreProperties({"transference", "company"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transference", cascade = CascadeType.ALL)
    private List<BeneficiaryTransferDetail> beneficiaryTransferDetails;
    
    @JsonIgnoreProperties({"transference"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transference", cascade = CascadeType.ALL)
    private List<CurrencyTransference> currencyTransferences;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private BankAccount bankAccount;

    @JsonIgnoreProperties({"user", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @JsonIgnoreProperties({"companies", "roles", "privileges", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    
    public Transference()  {
        this.currencyTransferences = new ArrayList<>();
    }

    @PrePersist
    public void prePersist() {
        this.date = new Date();
    }
}
