package matematica;

public class BinomioNewton {

	private int grado;
	private double x;
	private double b;
	
	public BinomioNewton(int grado, double x, double b) {
		this.grado = grado;
		this.x = x;
		this.b = b;
	}
	public BinomioNewton(int grado) {
		this.grado = grado;
		this.x = this.b = 0;
	}
	
	public BinomioNewton() {
		this(0,0,0);
	}
	
	public int getGrado() {
		return grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}
	public double getX() {
		return x;
	}
	public void setX(double coeficienteA) {
		this.x = coeficienteA;
	}
	public double getB() {
		return b;
	}
	public void setB(double coeficienteB) {
		this.b = coeficienteB;
	}

	
	public static int[] obtenerTerminosTarta(int nivel) {
		
		int[] resultado = new int[nivel];
		int[][] tartaglia = new int[nivel][nivel];
		
	    for(int i = 0 ; i < nivel; i++)
	    {
	        tartaglia[i][0] = 1;
	        for(int j= 1 ; j  <= i ; j++)
	                tartaglia[i][j]  = tartaglia[i-1][j-1]+ tartaglia[i-1][j];
	    }
		for (int i = 0; i < tartaglia[nivel -1].length; i++) {
			resultado[i] = tartaglia[nivel -1][i];
		}
		return resultado;
			
	}
	
	public String mostrarBinomioResuelto() {
		
		StringBuffer buffer = new StringBuffer();
		int [] terminos = obtenerTerminosTarta(this.getGrado() +1);
		double aux;
		for(int i = 0, j = this.getGrado(); i <= this.getGrado() ; j--,i ++) {
			
			aux = terminos[i]*Math.pow(this.getX(), j)*Math.pow(this.getB(),i);
			if(aux > 0)
			buffer.append("+");
			buffer.append(aux);
			buffer.append("X");
			buffer.append(j);
			
		}
		return buffer.toString();
	}
	
	public  double resolverBinomio() {
		
		double resultado = 0;
		int[] terminos = new int[this.getGrado()];
		terminos = obtenerTerminosTarta(this.getGrado()+1);
		for (int i = this.getGrado(), j = 0; i >= 0; i--, j++) {
			resultado += terminos[j]* Math.pow(this.x, i) * Math.pow(this.b, j);
		}
		

		return resultado;
	}
	
	//METODO DE CLASE
	public static double resolverBinomio(double x, double b, int grado,double valor) {
		
		double resultado = 0;
		int[] terminos = new int[grado];
		
		terminos = obtenerTerminosTarta(grado+1);
		for (int i = grado, j =0; i >= 0; i--, j++) 
			resultado += terminos[j] * Math.pow(valor*x, i) * Math.pow(b, j);
		
		

		return resultado;
	}	
	
}