package main;

public class Casa {
	private int area;
	private Tejado tejado;
	private Pared pared_1;
	private Pared pared_2;
	private Pared pared_3;
	private Pared pared_4;
	
	public Casa(int area, Tejado tejado, Pared pared_1, Pared pared_2, Pared pared_3, Pared pared_4) {
		this.area = area;
		this.tejado = tejado;
		this.pared_1 = pared_1;
		this.pared_2 = pared_2;
		this.pared_3 = pared_3;
		this.pared_4 = pared_4;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Tejado getTejado() {
		return tejado;
	}

	public void setTejado(Tejado tejado) {
		this.tejado = tejado;
	}

	public Pared getPared_1() {
		return pared_1;
	}

	public void setPared_1(Pared pared_1) {
		this.pared_1 = pared_1;
	}

	public Pared getPared_2() {
		return pared_2;
	}

	public void setPared_2(Pared pared_2) {
		this.pared_2 = pared_2;
	}

	public Pared getPared_3() {
		return pared_3;
	}

	public void setPared_3(Pared pared_3) {
		this.pared_3 = pared_3;
	}

	public Pared getPared_4() {
		return pared_4;
	}

	public void setPared_4(Pared pared_4) {
		this.pared_4 = pared_4;
	}

	@Override
	public String toString() {
		return "Casa [area=" + area + ", tejado=" + tejado + ", pared_1=" + pared_1 + ", pared_2=" + pared_2
				+ ", pared_3=" + pared_3 + ", pared_4=" + pared_4 + "]";
	}

}
