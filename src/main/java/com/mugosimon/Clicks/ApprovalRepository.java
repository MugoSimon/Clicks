package com.mugosimon.Clicks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalRepository
        extends JpaRepository<Approval, Long> {
}
