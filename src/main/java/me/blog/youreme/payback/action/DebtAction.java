package me.blog.youreme.payback.action;

import me.blog.youreme.payback.bo.DebtBO;
import me.blog.youreme.payback.model.DebtDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/{userId}")
public class DebtAction {
    @Autowired
    DebtBO debtBO;

    @RequestMapping("/payback")
	public String payback(ModelMap model, @PathVariable String userId) {
        List<DebtDependency> paybackList = new ArrayList<DebtDependency>();
        List<DebtDependency> debtList = debtBO.selectDebtList(userId);
        List<DebtDependency> receivableList = debtBO.selectReceivableList(userId);
        paybackList.addAll(debtList);
        paybackList.addAll(receivableList);

        model.addAttribute("userId", userId);
        model.addAttribute("paybackList", paybackList);

        Map<String, Integer> paybackCount = new HashMap<String, Integer>();
        paybackCount.put("all", debtList.size() + receivableList.size());
        paybackCount.put("debt", debtList.size());
        paybackCount.put("receivable", receivableList.size());
        model.addAttribute("paybackCount", paybackCount);

		return "payback";
	}

    @RequestMapping("/payback/debt")
    public String debt(ModelMap model, @PathVariable String userId) {
        List<DebtDependency> debtList = debtBO.selectDebtList(userId);
        List<DebtDependency> receivableList = debtBO.selectReceivableList(userId);

        model.addAttribute("userId", userId);
        model.addAttribute("paybackList", debtList);

        Map<String, Integer> paybackCount = new HashMap<String, Integer>();
        paybackCount.put("all", debtList.size() + receivableList.size());
        paybackCount.put("debt", debtList.size());
        paybackCount.put("receivable", receivableList.size());
        model.addAttribute("paybackCount", paybackCount);

        return "payback";
    }

    @RequestMapping("/payback/receivable")
    public String receivable(ModelMap model, @PathVariable String userId) {
        List<DebtDependency> debtList = debtBO.selectDebtList(userId);
        List<DebtDependency> receivableList = debtBO.selectReceivableList(userId);

        model.addAttribute("userId", userId);
        model.addAttribute("paybackList", receivableList);

        Map<String, Integer> paybackCount = new HashMap<String, Integer>();
        paybackCount.put("all", debtList.size() + receivableList.size());
        paybackCount.put("debt", debtList.size());
        paybackCount.put("receivable", receivableList.size());
        model.addAttribute("paybackCount", paybackCount);

        return "payback";
    }
}