package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.CongestionSituationDomain;

/**
 * DBアクセス用のリポジトリクラス
 * @author manami
 *
 */
@Repository
public class CongestionSituationRepository {
	private static final RowMapper<CongestionSituationDomain> CONGESTION_SITUATION_DOMAIN_ROW_MAPPER = (rs,i) -> {
		CongestionSituationDomain domain = new CongestionSituationDomain();
		domain.setId(rs.getInt("id"));
		domain.setName(rs.getString("name"));
		domain.setMaleComfortableNumberOfPeople(rs.getInt("male_comfortable_number_of_people"));
		domain.setMaleALittleNumberOfPeople(rs.getInt("male_a_little_number_of_people"));
		domain.setFemaleCongestionNumberOfPeople(rs.getInt("male_congestion_number_of_people"));
		domain.setFemaleComfortableNumberOfPeople(rs.getInt("female_comfortable_number_of_people"));
		domain.setFemaleALittleNumberOfPeople(rs.getInt("female_a_little_number_of_people"));
		domain.setFemaleCongestionNumberOfPeople(rs.getInt("female_congestion_number_of_people"));
		return domain;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 施設一覧を取得するためのメソッド
	 * @return 施設の全件情報を取得する
	 */
	public List<CongestionSituationDomain>  findAll() {
		String sql = "SELECT * FROM sauna_list ORDER BY id";
		List<CongestionSituationDomain> domainList = template.query(sql, CONGESTION_SITUATION_DOMAIN_ROW_MAPPER);
		return domainList;
	}
	
	/**
	 * idで該当情報を取得するためのメソッド
	 * @param Integer id
	 * @return 引数のidで検索した該当のレコードを取得する
	 */
	public CongestionSituationDomain load(Integer id) {
		String sql = "SELECT * FROM sauna_list WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		CongestionSituationDomain domain = template.queryForObject(sql, param, CONGESTION_SITUATION_DOMAIN_ROW_MAPPER);
		return domain;
	}
}
