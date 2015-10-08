package game;
import java.awt.Image;
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
	private Image naveImg;
	private List<Tiro> tiros;
	
	public Nave() {
		ImageIcon referencia = new ImageIcon ("res\\nave.gif");//Definimos o diretorio da imagem da nave.
		naveImg = referencia.getImage();
		
		tiros = new ArrayList<Tiro>();
		//Setamos a posi��o inicial da nave.
		this.x = 100;
		this.y = 100;
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
	
	//O x come�a da esquerda para direita e o y de cima para baixo.
	public void KeyPressed (KeyEvent tecla) { //Enquanto a tecla estiver sendo pressionada, ele ir� movimenta-la conforme as condi��es.
		
		int codigo = tecla.getKeyCode();
		
		if (codigo == KeyEvent.VK_UP) { // Tecla "Seta para cima" para movimentar a nave para cima.
			dy = -1;
		}
		
		if (codigo == KeyEvent.VK_DOWN) {// Tecla "Seta para baixo" para movimentar a nave para baixo.
			dy = 1;
		}
		
		if (codigo == KeyEvent.VK_LEFT) {// Tecla "Seta para esquerda" para movimentar a nave para esquerda.
			dx = -1;
		}
		
		if (codigo == KeyEvent.VK_RIGHT) {// Tecla "Seta para direita" para movimentar a nave para direita.
			dx = 1;
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
	

