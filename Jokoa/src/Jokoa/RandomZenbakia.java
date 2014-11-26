package Jokoa;

public class RandomZenbakia {
	//random zenbakia
	Double random;
	
	public RandomZenbakia() {
		random= Math.random();
	}

	public int getZenbakia() {
		double x = random * 100;
		//0 gerta daitekeelako
		int y = (int) x +1;
		System.out.println(y);
		return y;
	}

	public boolean asmatuDu(int zenb) {
		if (zenb==getZenbakia())
			return true;
		else
			return false;
	}
	
	public boolean handiagoaDa(int zenb) {
		if(zenb<getZenbakia())
			return false;
		else
			return true;
		
	}
}
