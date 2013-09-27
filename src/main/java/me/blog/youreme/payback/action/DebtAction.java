package me.blog.youreme.payback.action;

import me.blog.youreme.payback.bo.DebtBO;
import me.blog.youreme.payback.model.DebtDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DebtAction {
    @Autowired
    DebtBO debtBO;

    protected String getUserId() {
        return "hunky";
    }

    @RequestMapping("/")
	public String index(ModelMap model) {
        List<DebtDependency> debtList = debtBO.selectDebtList(getUserId());
        List<DebtDependency> receivableList = debtBO.selectReceivableList(getUserId());

        model.addAttribute("debtList", debtList);
        model.addAttribute("receivableList", receivableList);

		return "index";
	}
}