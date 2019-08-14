package com.ngochung.Banking.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngochung.Banking.dao.BankAccountDAO;
import com.ngochung.Banking.exception.BankTransactionException;
import com.ngochung.Banking.form.SendMoneyForm;
import com.ngochung.Banking.model.BankAccountInfo;

@Controller
public class MainController {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showBankAccounts(Model model) {
		List<BankAccountInfo> list = bankAccountDAO.listBankAccountInfo();
		model.addAttribute("accountInfos", list);
		
		return "accoutsPage";
	}
	
	
	@RequestMapping(value="/sendMoney", method=RequestMethod.GET)
	public String viewSenMoneyPage(Model model) {
		SendMoneyForm form = new SendMoneyForm(1L, 2L, 1000d);
		model.addAttribute("sendMoneyForm", form);
		
		return "sendMoneyPage";
	}
	
	@RequestMapping(value="/sendMoney", method=RequestMethod.POST)
	public String processSendMoney(Model model , SendMoneyForm sendMoneyForm) {
		System.out.println("Send money : " + sendMoneyForm.getAmount());
		
		try {
			bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(), sendMoneyForm.getToAccountId(), sendMoneyForm.getAmount());
		} catch (BankTransactionException e) {
			model.addAttribute("errorMessage","Error: " + e.getMessage());
		}
		return "redirect:/";
	}
	
}
