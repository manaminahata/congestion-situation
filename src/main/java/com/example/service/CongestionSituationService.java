package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.CongestionSituationDomain;
import com.example.repository.CongestionSituationRepository;

@Service
public class CongestionSituationService {
	@Autowired
	private CongestionSituationRepository repository;
	
	/**
	 * 施設一覧取得用のメソッド
	 * @return　施設の全件情報を取得する
	 */
	public List<CongestionSituationDomain> showList() {
		List<CongestionSituationDomain> domainList = repository.findAll();
		return domainList;
	}
	
	/**
	 * 施設登録用のメソッド
	 */
	public void insert(CongestionSituationDomain domain) {
		repository.save(domain);
	}
 }
