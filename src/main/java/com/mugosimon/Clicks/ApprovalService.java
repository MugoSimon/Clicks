package com.mugosimon.Clicks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalService {
    private final ApprovalRepository approvalRepository;

    @Autowired
    public ApprovalService(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    public Approval getApproval() {
        return approvalRepository.findById(1L).orElse(new Approval());
    }

    public void approveButton(Long userId) {
        Approval approval = getApproval();
        approval.setClickCount(approval.getClickCount() + 1);
        approval.getApprovedBy().add(userId);

        if (approval.getApprovedBy().size() >= 2) {
            approval.setApproved(true);
        }

        approvalRepository.save(approval);
    }
}

