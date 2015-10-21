package game;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Nave {
 
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int altura;
	private int largura;
	private boolean isVisivel;

	private static final int VELOCIDADE_NAVE = 2;
	
	private Image naveImg;
	private List<Tiro> tiros;
	
	public Nave() {
		
		ImageIcon referencia = new ImageIcon ("res\\nave.gif");//Definimos o diretorio da imagem da nave.
		naveImg = referencia.getImage();
		
		this.altura = naveImg.getHeight(null);
		this.largura = naveImg.getWidth(null);
		
		tiros = new ArrayList<Tiro>();
		
		//Setamos a posi��o inicial da nave.
		this.x = 275;
		this.y = 500;
	}
	
	public void mover() {

		x += dx; // somamos x com dx para que seja possivel realizar a movimenta��o da nave.
		y += dy; 
		
		//Os if's criados s�o para determinar o x limite e y limite que a nave pode se locomover.
		if (this.x < 1){
			x = 1;
		}
		
		if (this.x > 532){
			x = 532;
		}
		
		if (this.y < 1){
			y = 1;
		}
		
		if(this.y > 537){
			y = 537;
		}
		
	}
	
	public List<Tiro> getTiros() {
		return tiros;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getNaveImg() {
		return naveImg;
	}
	
	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	
	public void atirar() {
		this.tiros.add(new Tiro(getX() + (largura / 2) - 10, getY() + -1 * altura));
	}
	
	public Rectangle getBounds() {
		return new Rectangle (x, y, largura - 20, altura - 20);
	}
	
	//O x come�a da esquerda para direita e o y de cima para baixo.
	public void KeyPressed (KeyEvent tecla) { //Enquanto a tecla estiver sendo pressionada, ele ir� movimenta-la conforme as condi��es.
		
		int codigo = tecla.getKeyCode();
		
		if (codigo == KeyEvent.VK_SPACE) {
			atirar();
		}
		
		if (codigo == KeyEvent.VK_UP) { // Tecla "Seta para cima" para movimentar a nave para cima.
			dy = VELOCIDADE_NAVE - 4;
		}
		
		if (codigo == KeyEvent.VK_DOWN) {// Tecla "Seta para baixo" para movimentar a nave para baixo.
			dy = VELOCIDADE_NAVE;
		}
		
		if (codigo == KeyEvent.VK_LEFT) {// Tecla "Seta para esquerda" para movimentar a nave para esquerda.
			dx = VELOCIDADE_NAVE - 4;
		}
		
		if (codigo == KeyEvent.VK_RIGHT) {// Tecla "Seta para direita" para movimentar a nave para direita.
			dx = VELOCIDADE_NAVE;
		}
	}
		
	public void KeyReleased (KeyEvent tecla) { //Quando a tecla n�o estiver sendo mais pressionada, ele ir� deixar a nave parada conforme as condi��es.
		
		int codigo = tecla.getKeyCode();
		
		if (codigo == KeyEvent.VK_UP) {
			dy = 0;
		}
		
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		
		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
			
	}
	
}
	

