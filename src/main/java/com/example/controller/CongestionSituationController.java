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
	
	///////////////////////////////////////////////////
	//          　　　  施設一覧表示　　　　　　　　　　　　//
	///////////////////////////////////////////////////
	
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
	
	///////////////////////////////////////////////////
	//          　　　  ログイン設定　　　　　　　　　　　　//
	///////////////////////////////////////////////////
	
	/**
	 * 管理者ログイン用ページを表示させる
	 * @return login.html
	 */
	@RequestMapping("/index")
	public String index() {
		return "login";
	}
	
	/**
	 * ログイン用のメソッド
	 * @param email
	 * @param password
	 * @return　メールアドレスとパスワードが登録されたものと一致した場合は次の処理へ進める
	 */
	@RequestMapping("/number-management")
	public String login(String email, String password, Model model) {
		System.out.println(email);
		System.out.println(password);
		
		
		CongestionSituationDomain domain = service.searchForObject(email, password);
		
		
		if (domain == null) {
			model.addAttribute("errorMessage", "メールアドレスまたはパスワードが不正です。");
			return index();
		}
		
		model.addAttribute("domain", domain);
		
		return "number-management";
	}
	
	///////////////////////////////////////////////////
	//          　　　  施設の新規登録設定　　　　　　　　　//
	///////////////////////////////////////////////////
	
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
		System.out.println("qwertyuiasdfghjksdfghjksdfghjkl");
		System.out.println(form);
		CongestionSituationDomain domain = new CongestionSituationDomain();
		BeanUtils.copyProperties(form, domain);
		domain.setMaleComfortableNumberOfPeople(form.getIntMaleComfortableNumberOfPeople());
		domain.setMaleALittleNumberOfPeople(form.getIntMaleALittleNumberOfPeople());
		domain.setMaleCongestionNumberOfPeople(form.getIntMaleCongestionNumberOfPeople());
		domain.setFemaleComfortableNumberOfPeople(form.getIntFemaleComfortableNumberOfPeople());
		domain.setFemaleALittleNumberOfPeople(form.getIntFemaleALittleNumberOfPeople());
		domain.setFemaleCongestionNumberOfPeople(form.getIntFemaleCongestionNumberOfPeople());
		
		System.out.println("qwertyuiasdfghjksdfghjksdfghjkl");
		System.out.println(domain);
				
				
		service.insert(domain);
		
		return "addition-completed";
	}
	
	///////////////////////////////////////////////////
	//       　　ログイン成功後混雑状況管理の設定　　　　　　//
	///////////////////////////////////////////////////
	
	
}
