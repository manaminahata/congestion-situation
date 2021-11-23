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
		domain.setEmail(rs.getString("email"));
		domain.setPassword(rs.getString("password"));
		domain.setMaleComfortableNumberOfPeople(rs.getInt("male_comfortable_number_of_people"));
		domain.setMaleALittleNumberOfPeople(rs.getInt("male_a_little_number_of_people"));
		domain.setMaleCongestionNumberOfPeople(rs.getInt("male_congestion_number_of_people"));
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
	 * ログイン時にメールアドレスとパスワードが一致しているか確認するためのメソッド
	 * @param email
	 * @param password
	 * @return　メールアドレスとパスワードが一致した施設を取得する
	 */
	public CongestionSituationDomain findByEmailAndPassword(String email, String password) {
		String sql = "SELECT * FROM sauna_list WHERE email=:email AND password=:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password", password);
		
		List<CongestionSituationDomain> domainList = template.query(sql, param, CONGESTION_SITUATION_DOMAIN_ROW_MAPPER);
		if (domainList.size() == 0) {
			return null;
		}
		return domainList.get(0);
	}
	
	/**
	 * データ更新用のメソッド
	 * @param domain
	 * @return　更新用のデータをDBに返す
	 * 
	 */
	public CongestionSituationDomain save(CongestionSituationDomain domain) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(domain);
		String updateSql = "UPDATE sauna_list SET name=:name, email=:email, password=:password, male_comfortable_number_of_people=:male_comfortable_number_of_people, male_a_little_number_of_people=:male_a_little_number_of_people,"
					+ " male_congestion_number_of_people=:male_congestion_number_of_people, female_comfortable_number_of_people=:female_comfortable_number_of_people, "
					+ "　female_a_little_number_of_people=:female_a_little_number_of_people, female_congestion_number_of_people=:female_congestion_number_of_people, url=:url) WHERE id=:id";
		template.update(updateSql, param);
		return domain;
	}
	
	/**
	 * 新規施設追加用メソッド
	 * @param domain
	 */
	public void insert(CongestionSituationDomain domain) {
//	String insertSql = "INSERT INTO sauna_list (name, email, password, male_comfortable_number_of_people, male_a_little_number_of_people,"//
//				+ " male_congestion_number_of_people, female_comfortable_number_of_people, female_a_little_number_of_people, female_congestion_number_of_people, url)"
//				+ "　VALUES (:name, :email, :password, :male_comfortable_number_of_people, :male_a_little_number_of_people,"
//				+ " :male_congestion_number_of_people, :female_comfortable_number_of_people, :female_a_little_number_of_people, :female_congestion_number_of_people, :url)";
		
		String insertSql = "INSERT INTO sauna_list (name, email, password, male_comfortable_number_of_people, male_a_little_number_of_people,"
				+ " male_congestion_number_of_people, female_comfortable_number_of_people, female_a_little_number_of_people, female_congestion_number_of_people, url)"
				+ " VALUES (:name, :email, :password, :maleComfortableNumberOfPeople, :maleALittleNumberOfPeople,"
				+ " :maleCongestionNumberOfPeople, :femaleComfortableNumberOfPeople, :femaleALittleNumberOfPeople, :femaleCongestionNumberOfPeople, :url)";
		System.out.println("qwertyuiopdfghjkl");
		System.out.println(domain);
		SqlParameterSource param = new BeanPropertySqlParameterSource(domain);
		template.update(insertSql, param);
		
	}
	
	
}
