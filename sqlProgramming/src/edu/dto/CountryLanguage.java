package edu.dto;

public class CountryLanguage {
	private String CountryCode;
	private String Language;
	private String IsOfficial;
	private float Percentage;
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getIsOfficial() {
		return IsOfficial;
	}
	public void setIsOfficial(String isOfficial) {
		IsOfficial = isOfficial;
	}

	public float getPercentage() {
		return Percentage;
	}
	public void setPercentage(float percentage) {
		Percentage = percentage;
	}
	public String toString() {
		return "countrylanguage [CountryCode=" + CountryCode + ", Language=" + Language + ", IsOfficial=" + IsOfficial
				+ ", Percentage=" + Percentage + "]";
	}
}
