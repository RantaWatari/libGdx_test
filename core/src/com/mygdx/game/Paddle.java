package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class Paddle {
    int x;
    int y;
    int width;
    int heigth;
    int[] xXyY = new int[4]; 
    Color color = Color.WHITE;

    public Paddle(int x, int y, int width, int heigth) {
        this.x = x-width/2;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
    }

    public void update() {
	if(0 != Gdx.input.getX()){
		this.x = Gdx.input.getX()-width/2;
//	System.out.println(xXyY[0] + "," + xXyY[1] + "," + xXyY[2] + "," + xXyY[3]);
	}
	
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
       shape.rect(x, y, width, heigth);
    }

    public int[] rectxXyY() {
	xXyY[0] = x;
	xXyY[1] = x + width;
	xXyY[2] = y;
	xXyY[3] = y + heigth;

	return xXyY;
    }
}