package com.widambe.dwPortifolio.contact;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact_us")
public class Contacts {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String subject;
    private String Message;
    @CreationTimestamp
    private LocalDateTime createdAt;


}
