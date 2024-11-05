package com.example.banking.entities;

import com.example.banking.enums.AccountStatus;
import jakarta.persistence.*;
import jdk.dynalink.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4)
@Data @NoArgsConstructor @AllArgsConstructor
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private double balance;
    private AccountStatus status;
    private String currency;
    @ManyToOne
    private Customer customer;
    @OneToMany (mappedBy = "bankAccount")
    private List<AccountOperation> operations;
}
