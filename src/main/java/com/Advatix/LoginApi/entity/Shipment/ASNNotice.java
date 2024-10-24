package com.Advatix.LoginApi.entity.Shipment;

import com.Advatix.LoginApi.entity.User.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "asn_notice")
@Data
@NoArgsConstructor
public class ASNNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asn_id")
    private Long asnId;

    private String poNumber;

    private String lotNumber;

    private Long totalQuantity;

    private LocalDate createdOn;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;


    //for one to many join use this to make a fk constraint in the joined table and donot add column name in joined table
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_asn_id", referencedColumnName = "asn_id")
    private List<ASNUnits> asnUnitsList;
}

