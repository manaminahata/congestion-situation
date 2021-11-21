package com.example.form;


/**
 * 登録フォーム(insert.html)を受け取るフォームクラス
 * @author manami
 *
 */
public class CongestionSituationForm {
	// 施設名
	private String name;
	// メールアドレス
	private String email;
	// パスワード
	private String password;
	// 男性用の快適に過ごせる人数
	private String maleComfortableNumberOfPeople;
	// 男性用のやや混雑している人数
	private String maleALittleNumberOfPeople;
	// 男性用の混雑している人数
	private String maleCongestionNumberOfPeople;
	// 女性用の快適に過ごせる人数
	private String femaleComfortableNumberOfPeople;
	// 女性用のやや混雑している人数
	private String femaleALittleNumberOfPeople; 
	// 女性用の混雑している人数
	private String femaleCongestionNumberOfPeople;
	// 各施設のURL
	private String url;
	
	
	
	// getter/setterを定義
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMaleComfortableNumberOfPeople() {
		return maleComfortableNumberOfPeople;
	}
	public void setMaleComfortableNumberOfPeople(String maleComfortableNumberOfPeople) {
		this.maleComfortableNumberOfPeople = maleComfortableNumberOfPeople;
	}
	public String getMaleALittleNumberOfPeople() {
		return maleALittleNumberOfPeople;
	}
	public void setMaleALittleNumberOfPeople(String maleALittleNumberOfPeople) {
		this.maleALittleNumberOfPeople = maleALittleNumberOfPeople;
	}
	public String getMaleCongestionNumberOfPeople() {
		return maleCongestionNumberOfPeople;
	}
	public void setMaleCongestionNumberOfPeople(String maleCongestionNumberOfPeople) {
		this.maleCongestionNumberOfPeople = maleCongestionNumberOfPeople;
	}
	public String getFemaleComfortableNumberOfPeople() {
		return femaleComfortableNumberOfPeople;
	}
	public void setFemaleComfortableNumberOfPeople(String femaleComfortableNumberOfPeople) {
		this.femaleComfortableNumberOfPeople = femaleComfortableNumberOfPeople;
	}
	public String getFemaleALittleNumberOfPeople() {
		return femaleALittleNumberOfPeople;
	}
	public void setFemaleALittleNumberOfPeople(String femaleALittleNumberOfPeople) {
		this.femaleALittleNumberOfPeople = femaleALittleNumberOfPeople;
	}
	public String getFemaleCongestionNumberOfPeople() {
		return femaleCongestionNumberOfPeople;
	}
	public void setFemaleCongestionNumberOfPeople(String femaleCongestionNumberOfPeople) {
		this.femaleCongestionNumberOfPeople = femaleCongestionNumberOfPeople;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	// String型からInteger型変換
		public Integer getIntMaleComfortableNumberOfPeople() {
			return Integer.parseInt(maleComfortableNumberOfPeople);
		}
		public Integer getIntMaleALittleNumberOfPeople() {
			return Integer.parseInt(maleALittleNumberOfPeople);
		}
		public Integer getIntMaleCongestionNumberOfPeople() {
			return Integer.parseInt(maleCongestionNumberOfPeople);
		}
		public Integer getIntFemaleComfortableNumberOfPeople() {
			return Integer.parseInt(femaleComfortableNumberOfPeople);
		}
		public Integer getIntFemaleALittleNumberOfPeople() {
			return Integer.parseInt(femaleALittleNumberOfPeople);
		}
		public Integer getIntFemaleCongestionNumberOfPeople() {
			return Integer.parseInt(femaleCongestionNumberOfPeople);
		}
	
	@Override
	public String toString() {
		return "CongestionSituationForm [name=" + name + ", email=" + email + ", password=" + password
				+ ", maleComfortableNumberOfPeople=" + maleComfortableNumberOfPeople + ", maleALittleNumberOfPeople="
				+ maleALittleNumberOfPeople + ", maleCongestionNumberOfPeople=" + maleCongestionNumberOfPeople
				+ ", femaleComfortableNumberOfPeople=" + femaleComfortableNumberOfPeople
				+ ", femaleALittleNumberOfPeople=" + femaleALittleNumberOfPeople + ", femaleCongestionNumberOfPeople="
				+ femaleCongestionNumberOfPeople + ", url=" + url + "]";
	}

}
