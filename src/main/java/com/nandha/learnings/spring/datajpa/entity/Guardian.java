package com.nandha.learnings.spring.datajpa.entity;

import com.sun.tracing.dtrace.NameAttributes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column =@Column(name = "guardian_name")),
        @AttributeOverride(name = "email", column =@Column(name = "guardian_email", nullable = false, unique = true)),
        @AttributeOverride(name = "mobileNumber", column =@Column(name = "guardian_phone"/*,nullable = false, unique = true*/))
})
public class Guardian {
    private String name;
    private String email;
    private String mobileNumber;
}
