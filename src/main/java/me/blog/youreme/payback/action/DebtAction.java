package me.blog.youreme.payback.action;

import java.util.*;

import me.blog.youreme.payback.bo.DebtBO;
import me.blog.youreme.payback.model.DebtDependency;

import me.blog.youreme.payback.model.DebtHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{userId}")
public class DebtAction {
	@Autowired
	DebtBO debtBO;

	@RequestMapping("/payback")
	public String payback(ModelMap model, @PathVariable String userId) {
        Map<String, Object> commonData = getCommonData(userId);
        
        List<DebtHistory> paybackList = new ArrayList<DebtHistory>();
        paybackList.addAll((List<DebtHistory>) commonData.get("debtHistoryList"));
        paybackList.addAll((List<DebtHistory>) commonData.get("receivableHistoryList"));

        model.addAttribute("userId", userId);
        model.addAttribute("paybackList", paybackList);
        model.addAttribute("paybackCount", commonData.get("paybackCount"));
        model.addAttribute("dependency", commonData.get("dependency"));
        model.addAttribute("debtKey", commonData.get("debtKey"));

		return "payback";
	}

	@RequestMapping("/payback/debt")
	public String debt(ModelMap model, @PathVariable String userId) {
        Map<String, Object> commanData = getCommonData(userId);

        model.addAttribute("userId", userId);
		model.addAttribute("paybackList", commanData.get("debtHistoryList"));
        model.addAttribute("paybackCount", commanData.get("paybackCount"));
        model.addAttribute("dependency", commanData.get("dependency"));
        model.addAttribute("debtKey", commanData.get("debtKey"));

		return "payback";
	}

	@RequestMapping("/payback/receivable")
	public String receivable(ModelMap model, @PathVariable String userId) {
        Map<String, Object> commanData = getCommonData(userId);

        model.addAttribute("userId", userId);
        model.addAttribute("paybackList", commanData.get("receivableHistoryList"));
        model.addAttribute("paybackCount", commanData.get("paybackCount"));
        model.addAttribute("dependency", commanData.get("dependency"));
        model.addAttribute("debtKey", commanData.get("debtKey"));

		return "payback";
	}

	protected Map<String, Object> getCommonData(String userId) {
        Map<String, Object> commonData = new HashMap<String, Object>();

        List<DebtHistory> debtHistoryList = debtBO.selectDebtHistoryList(userId);
        List<DebtHistory> receivableHistoryList = debtBO.selectReceivableHistoryList(userId);

		Map<String, Integer> paybackCount = new HashMap<String, Integer>();
		paybackCount.put("all", debtHistoryList.size() + receivableHistoryList.size());
		paybackCount.put("debt", debtHistoryList.size());
		paybackCount.put("receivable", receivableHistoryList.size());

        commonData.put("debtHistoryList", debtHistoryList);
        commonData.put("receivableHistoryList", receivableHistoryList);
		commonData.put("paybackCount", paybackCount);

        List<DebtDependency> debtList = debtBO.selectDebtList(userId);
        List<DebtDependency> receivableList = debtBO.selectReceivableList(userId);
		Map<String, Integer> dependency = new HashMap<String, Integer>();
		for (DebtDependency debt : debtList) {
			String uid = debt.getCreditor();
			int amount = -debt.getAmount();
			if (dependency.get(uid) != null) {
				dependency.put(uid, dependency.get(uid) + amount);
			} else {
				dependency.put(uid, amount);
			}
		}

		for (DebtDependency receivable : receivableList) {
			String uid = receivable.getDebtor();
			int amount = receivable.getAmount();
			if (dependency.get(uid) != null) {
				dependency.put(uid, dependency.get(uid) + amount);
			} else {
				dependency.put(uid, amount);
			}
		}

		commonData.put("dependency", dependency);
        commonData.put("debtKey", dependency.keySet());

		return commonData;
	}

}
