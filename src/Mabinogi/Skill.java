package Mabinogi;

public class Skill {
	
	// 이름, 랭크, 데미지, 설명
	private String name, explanation;
	private String rank;
	private int ap;
	private double damage;
	
	public Skill(String name, String rank, int ap, double damage, String explanation) {
		
		this.name = name;
		this.rank = rank;
		this.ap = ap;
		this.damage = damage;
		this.explanation = explanation;
	}

	public String getName() {
		return name;
	}

	public String getExplanation() {
		return explanation;
	}

	public String getRank() {
		return rank;
	}

	public int getAp() {
		return ap;
	}

	public double getDamage() {
		return damage;
	}
	
	
}
