package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name="cust_id")
    private int custId;

    @Size(min = 2,message = "Should aleast contains two charcter")
    @Column(name="cust_name")
    private String custName;


    @Column(name="cust_address")
    private String custAddress;


    @Column(name="cust_acc_balance")
    private double  custAccBalance;

    @Range(min=1000000000,max = 9999999999l)
    @Column(name="cust_contact_number",unique=true)
    private long custContactNumber;

    @Column(name="cust_dob")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date custDob;

    @Column(name="cust_email_id",unique = true)
    @Size(message = "Emaild Should be valid")
    private String custEmailId;

    @Size(min = 4,message = "At least should contain 4 char")
    @Column(name="cust_password")
    private String custPassword;


}
