package me.blog.youreme.payback.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.blog.youreme.payback.bo.DebtBO;
import me.blog.youreme.payback.model.DebtDependency;

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
		List<DebtDependency> paybackList = new ArrayList<DebtDependency>();
		List<DebtDependency> debtList = debtBO.selectDebtList(userId);
		List<DebtDependency> receivableList = debtBO.selectReceivableList(userId);
		paybackList.addAll(debtList);
		paybackList.addAll(receivableList);

		model.addAttribute("userId", userId);
		model.addAttribute("paybackList", paybackList);

        Map<String, Object> commanData = getCommonData(debtList, receivableList);

        model.addAttribute("paybackCount", commanData.get("paybackCount"));
        model.addAttribute("dependency", commanData.get("dependency"));
        model.addAttribute("debtKey", commanData.get("debtKey"));

		return "payback";
	}

	@RequestMapping("/payback/debt")
	public String debt(ModelMap model, @PathVariable String userId) {
		List<DebtDependency> debtList = debtBO.selectDebtList(userId);
		List<DebtDependency> receivableList = debtBO.selectReceivableList(userId);

		model.addAttribute("userId", userId);
		model.addAttribute("paybackList", debtList);

        Map<String, Object> commanData = getCommonData(debtList, receivableList);

        model.addAttribute("paybackCount", commanData.get("paybackCount"));
        model.addAttribute("dependency", commanData.get("dependency"));
        model.addAttribute("debtKey", commanData.get("debtKey"));

		return "payback";
	}

	@RequestMapping("/payback/receivable")
	public String receivable(ModelMap model, @PathVariable String userId) {
		List<DebtDependency> debtList = debtBO.selectDebtList(userId);
		List<DebtDependency> receivableList = debtBO.selectReceivableList(userId);

		model.addAttribute("userId", userId);
		model.addAttribute("paybackList", receivableList);

        Map<String, Object> commanData = getCommonData(debtList, receivableList);

        model.addAttribute("paybackCount", commanData.get("paybackCount"));
        model.addAttribute("dependency", commanData.get("dependency"));
        model.addAttribute("debtKey", commanData.get("debtKey"));

		return "payback";
	}

	protected Map<String, Object> getCommonData(List<DebtDependency> debtList, List<DebtDependency> receivableList) {
		Map<String, Object> commonData = new HashMap<String, Object>();

		Map<String, Integer> paybackCount = new HashMap<String, Integer>();
		paybackCount.put("all", debtList.size() + receivableList.size());
		paybackCount.put("debt", debtList.size());
		paybackCount.put("receivable", receivableList.size());

		commonData.put("paybackCount", paybackCount);

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
