package com.mugosimon.Clicks;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clicks")

public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int clickCount;
    private boolean approved;
    private Set<Long> approvedBy = new HashSet<>();

    // Constructors, getters, and setters
}


