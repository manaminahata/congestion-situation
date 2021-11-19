package com.example.repository;

import org.springframework.jdbc.core.RowMapper;
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
}
