package com.revature.models;

public class Requirements {

	private String goodname;
	private int timber;
	private int coarseleather;
	private int linen;
	private int ironingot;
	private int greenwood;
	private int ironore;
	private int rawhide;
	private int fibers;
	
	public Requirements() {	
	}
	
	public Requirements(int goodname,
	int timber,
	int coarseleather,
	int linen,
	int ironingot,
	int greenwood,
	int ironore,
	int rawhide,
	int fibers) {
		super();
		
		this.timber = timber;
		this.coarseleather = coarseleather;
		this.linen = linen;
		this.ironingot = ironingot;
		this.greenwood = greenwood;
		this.ironore = ironore;
		this.rawhide = rawhide;
		this.fibers = fibers;
		
	}
	
	
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public int getTimber() {
		return timber;
	}
	public void setTimber(int timber) {
		this.timber = timber;
	}
	public int getCoarseleather() {
		return coarseleather;
	}
	public void setCoarseleather(int coarseleather) {
		this.coarseleather = coarseleather;
	}
	public int getLinen() {
		return linen;
	}
	public void setLinen(int linen) {
		this.linen = linen;
	}
	public int getIroningot() {
		return ironingot;
	}
	public void setIroningot(int ironingot) {
		this.ironingot = ironingot;
	}
	public int getGreenwood() {
		return greenwood;
	}
	public void setGreenwood(int greenwood) {
		this.greenwood = greenwood;
	}
	public int getIronore() {
		return ironore;
	}
	public void setIronore(int ironore) {
		this.ironore = ironore;
	}
	public int getRawhide() {
		return rawhide;
	}
	public void setRawhide(int rawhide) {
		this.rawhide = rawhide;
	}
	public int getFibers() {
		return fibers;
	}
	public void setFibers(int fibers) {
		this.fibers = fibers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coarseleather;
		result = prime * result + fibers;
		result = prime * result + ((goodname == null) ? 0 : goodname.hashCode());
		result = prime * result + greenwood;
		result = prime * result + ironingot;
		result = prime * result + ironore;
		result = prime * result + linen;
		result = prime * result + rawhide;
		result = prime * result + timber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requirements other = (Requirements) obj;
		if (coarseleather != other.coarseleather)
			return false;
		if (fibers != other.fibers)
			return false;
		if (goodname == null) {
			if (other.goodname != null)
				return false;
		} else if (!goodname.equals(other.goodname))
			return false;
		if (greenwood != other.greenwood)
			return false;
		if (ironingot != other.ironingot)
			return false;
		if (ironore != other.ironore)
			return false;
		if (linen != other.linen)
			return false;
		if (rawhide != other.rawhide)
			return false;
		if (timber != other.timber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Requirements [goodname=" + goodname + ", timber=" + timber + ", coarseleather=" + coarseleather
				+ ", linen=" + linen + ", ironingot=" + ironingot + ", greenwood=" + greenwood + ", ironore=" + ironore
				+ ", rawhide=" + rawhide + ", fibers=" + fibers + "]";
	}
	
	
}
