package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
		domain.setUrl(rs.getString("url"));
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
	
	
	/**
	 * idがnullであればinsert、idがnullでなければupdateするメソッドを定義
	 * @param domain
	 * @return　idがnullの場合、施設を追加する。idがnull出ない場合、既にあるデータを更新する。
	 * 
	 */
	public CongestionSituationDomain save(CongestionSituationDomain domain) {
		SqlParameterSource param = new BeanPropertySqlParameterSource("domain");
		
		if (domain.getId() == null) {
			// 下記にて施設を追加する
			String insertSql = "INSERT INTO sauna_list (name, male_comfortable_number_of_people, male_a_little_number_of_people,"
					+ " male_congestion_number_of_people, female_comfortable_number_of_people, female_a_little_number_of_people, female_congestion_number_of_people, url)"
					+ "　VALUES (:name, :male_comfortable_number_of_people, :male_a_little_number_of_people,\"\n"
					+ "				+ \" :male_congestion_number_of_people, :female_comfortable_number_of_people, :female_a_little_number_of_people, :female_congestion_number_of_people, :url)";
			template.update(insertSql, param);
		} else {
			// 下記にて施設を更新する
			String updateSql = "UPDATE sauna_list SET name=:name, male_comfortable_number_of_people=:male_comfortable_number_of_people, male_a_little_number_of_people=:male_a_little_number_of_people,"
					+ " male_congestion_number_of_people=:male_congestion_number_of_people, female_comfortable_number_of_people=:female_comfortable_number_of_people, "
					+ "　female_a_little_number_of_people=:female_a_little_number_of_people, female_congestion_number_of_people=:female_congestion_number_of_people, url=:url) WHERE id=:id";
			template.update(updateSql, param);
		}
		return domain;
	}
	
	
}
