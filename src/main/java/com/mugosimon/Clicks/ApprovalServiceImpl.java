package com.mugosimon.Clicks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalServiceImpl implements ApprovalService {
    private final ApprovalRepository approvalRepository;

    @Autowired
    public ApprovalServiceImpl(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    @Override
    public Approval getApproval() {
        return approvalRepository.findById(1L).orElse(new Approval());
    }

    @Override
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
