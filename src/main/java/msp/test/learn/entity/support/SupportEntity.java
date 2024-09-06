package msp.test.learn.entity.support;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "support",schema = "public")
public class SupportEntity {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer customerId;

    @Column(name = "customer_name")
    public String customerName;

    @Column(name = "customer_mob_no")
    public String customerMobNo;

    @Column(name = "customer_email")
    public String customerEmail;
}
