package game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Tiro {

	private Image tiroImg;
	private Image tiroBossImg;
	private int x;
	private int y;
	private int altura, alturaBoss;
	private int largura, larguraBoss;
	
	private boolean isVisivel;
	
	private static final int COMPRIMENTO_TELA = 600;
	private static final int VELOCIDADE_TIRO = 2;
	
	public Tiro(double x, double y){
		
		this.x = (int) x;
		this.y = (int) y;
		
		ImageIcon referencia1 = new ImageIcon("res\\tiro.png");
		ImageIcon referencia2 = new ImageIcon("res\\tiroboss.png");
		tiroImg = referencia1.getImage();
		tiroBossImg = referencia2.getImage();
		
		this.largura = tiroImg.getWidth(null);
		this.altura = tiroImg.getHeight(null);
		
		this.larguraBoss = tiroBossImg.getWidth(null);
		this.alturaBoss = tiroBossImg.getHeight(null);
		
		
		
		isVisivel = true;
		
	}
	
	public void mover() {
	
		this.y -= VELOCIDADE_TIRO;
		if(this.y > COMPRIMENTO_TELA) {
			isVisivel = false;		
		}	
			
	}
	
	public void moverTiroBoss() {
		
		this.y += VELOCIDADE_TIRO;
		if(this.y > COMPRIMENTO_TELA) {
			isVisivel = false;		
		}	
			
	}
	
	public boolean isVisivel() {
	    return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public Image getTiroImg() {
		return tiroImg;
	}
	
	public Image getTiroBossImg() {
		return tiroBossImg;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Rectangle2D getBounds() {
		return new Rectangle (x, y, largura, altura);
	}
	
	public void Apagatiro() throws Throwable{
		this.finalize();
	}
	
}
