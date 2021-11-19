package com.example.domain;

/**
 * ドメインクラス
 * @author manami
 *
 */
public class CongestionSituationDomain {
	// id
	private Integer id;
	// 施設名
	private String name;
	// 男性用の快適に過ごせる人数
	private Integer maleComfortableNumberOfPeople;
	// 男性用のやや混雑している人数
	private Integer maleALittleNumberOfPeople;
	// 男性用の混雑している人数
	private Integer maleCongestionNumberOfPeople;
	// 女性用の快適に過ごせる人数
	private Integer femaleComfortableNumberOfPeople;
	// 女性用のやや混雑している人数
	private Integer femaleALittleNumberOfPeople; 
	// 女性用の混雑している人数
	private Integer femaleCongestionNumberOfPeople;
	
	// 下記でgetter/setterを定義
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMaleComfortableNumberOfPeople() {
		return maleComfortableNumberOfPeople;
	}
	public void setMaleComfortableNumberOfPeople(Integer maleComfortableNumberOfPeople) {
		this.maleComfortableNumberOfPeople = maleComfortableNumberOfPeople;
	}
	public Integer getMaleALittleNumberOfPeople() {
		return maleALittleNumberOfPeople;
	}
	public void setMaleALittleNumberOfPeople(Integer maleALittleNumberOfPeople) {
		this.maleALittleNumberOfPeople = maleALittleNumberOfPeople;
	}
	public Integer getMaleCongestionNumberOfPeople() {
		return maleCongestionNumberOfPeople;
	}
	public void setMaleCongestionNumberOfPeople(Integer maleCongestionNumberOfPeople) {
		this.maleCongestionNumberOfPeople = maleCongestionNumberOfPeople;
	}
	public Integer getFemaleComfortableNumberOfPeople() {
		return femaleComfortableNumberOfPeople;
	}
	public void setFemaleComfortableNumberOfPeople(Integer femaleComfortableNumberOfPeople) {
		this.femaleComfortableNumberOfPeople = femaleComfortableNumberOfPeople;
	}
	public Integer getFemaleALittleNumberOfPeople() {
		return femaleALittleNumberOfPeople;
	}
	public void setFemaleALittleNumberOfPeople(Integer femaleALittleNumberOfPeople) {
		this.femaleALittleNumberOfPeople = femaleALittleNumberOfPeople;
	}
	public Integer getFemaleCongestionNumberOfPeople() {
		return femaleCongestionNumberOfPeople;
	}
	public void setFemaleCongestionNumberOfPeople(Integer femaleCongestionNumberOfPeople) {
		this.femaleCongestionNumberOfPeople = femaleCongestionNumberOfPeople;
	}
	
	@Override
	public String toString() {
		return "CongestionSituationDomain [id=" + id + ", name=" + name + ", maleComfortableNumberOfPeople="
				+ maleComfortableNumberOfPeople + ", maleALittleNumberOfPeople=" + maleALittleNumberOfPeople
				+ ", maleCongestionNumberOfPeople=" + maleCongestionNumberOfPeople
				+ ", femaleComfortableNumberOfPeople=" + femaleComfortableNumberOfPeople
				+ ", femaleALittleNumberOfPeople=" + femaleALittleNumberOfPeople + ", femaleCongestionNumberOfPeople="
				+ femaleCongestionNumberOfPeople + "]";
	}
}
