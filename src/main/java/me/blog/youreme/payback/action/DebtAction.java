package me.blog.youreme.payback.action;

import me.blog.youreme.payback.bo.DebtBO;
import me.blog.youreme.payback.model.DebtDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/{userId}")
public class DebtAction {
    @Autowired
    DebtBO debtBO;

    @RequestMapping("/debt")
	public String index(ModelMap model, @PathVariable String userId) {
        List<DebtDependency> debtList = debtBO.selectDebtList(userId);
        List<DebtDependency> receivableList = debtBO.selectReceivableList(userId);

        model.addAttribute("debtList", debtList);
        model.addAttribute("receivableList", receivableList);

		return "debt";
	}
}