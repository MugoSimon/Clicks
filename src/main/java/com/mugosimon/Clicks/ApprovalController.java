package com.mugosimon.Clicks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
//@RequestMapping("/clicks")
public class ApprovalController {
    private final ApprovalService approvalService;

    @Autowired
    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @GetMapping("/")
    public String home(Model model) {
        Approval approval = approvalService.getApproval();
        model.addAttribute("approval", approval);
        return "home";
    }

    @PostMapping("/approve")
    public String approve() {
        // Get the current user ID (you can replace this with your actual user authentication logic)
        Long currentUserId = 123L;

        approvalService.approveButton(currentUserId);

        return "redirect:/";
    }
}
