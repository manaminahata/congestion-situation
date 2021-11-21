package com.example.controller;

import java.util.List;

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
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
