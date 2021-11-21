package com.example.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.CongestionSituationDomain;
import com.example.form.CongestionSituationForm;
import com.example.service.CongestionSituationService;

@Controller
@RequestMapping("/sauna-list")
public class CongestionSituationController {
	@Autowired
	private CongestionSituationService service;
	
	@ModelAttribute
	public CongestionSituationForm setUpForm() {
		return new CongestionSituationForm();
	}
	
	/**
	 * 施設一覧を表示させる
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String showList(Model model) {
		List<CongestionSituationDomain> domainList =  service.showList();
		model.addAttribute("domainList", domainList);
		return "sauna-list";
	}
	
	/**
	 * 管理者ログイン用ページを表示させる
	 * @return login.html
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	/**
	 * 新規登録用のページを表示させる
	 * @return insert.html
	 */
	@RequestMapping("/insert")
	public String insert() {
		return "insert";
	}
	
	/**
	 * 施設の登録
	 * 登録完了後、ログインページに遷移させる
	 * @param form
	 * @param model
	 * @return login.html
	 */
	@RequestMapping("/addition-completed")
	public String additionCompleted(CongestionSituationForm form, Model model) {
		CongestionSituationDomain domain = new CongestionSituationDomain();
		BeanUtils.copyProperties(form, domain);
		domain.setMaleComfortableNumberOfPeople(form.getIntMaleComfortableNumberOfPeople());
		domain.setMaleALittleNumberOfPeople(form.getIntMaleALittleNumberOfPeople());
		domain.setMaleCongestionNumberOfPeople(form.getIntMaleCongestionNumberOfPeople());
		domain.setFemaleComfortableNumberOfPeople(form.getIntFemaleComfortableNumberOfPeople());
		domain.setFemaleALittleNumberOfPeople(form.getIntFemaleALittleNumberOfPeople());
		domain.setFemaleCongestionNumberOfPeople(form.getIntFemaleCongestionNumberOfPeople());
		service.insert(domain);
		return "redirect:login";
	}
	
	
	
	
}
