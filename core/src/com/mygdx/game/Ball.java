package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    Color color = Color.GREEN;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update(int[] PXY) {
        x += xSpeed;
        y += ySpeed;
        if (x < 0 + size || x > Gdx.graphics.getWidth() - size || PXY[0]-size == x && PXY[2] + size <= y && y <= PXY[3] + size || PXY[1]+size == x && PXY[2] + size <= y && y <= PXY[3] + size) {
            xSpeed = -xSpeed;
        } 
// paddle と block、X軸の左右壁、Y軸の天井に衝突した時のコードは複雑になる。 
// 現状、下記のコードは床が無い。X軸とsizeが考慮されてない。
        if (PXY[0] <= x && x <= PXY[1] && PXY[2] + size <= y && y <= PXY[3] + size || y > Gdx.graphics.getHeight() - size) {
            ySpeed = -ySpeed;
        }  

    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }

}