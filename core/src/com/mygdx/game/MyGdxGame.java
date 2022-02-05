package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class MyGdxGame extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;
    Ball ball2;
    Paddle paddle;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball( Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 25,4,4);
        paddle= new Paddle(Gdx.graphics.getWidth()/2,10, 100, 5);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        paddle.update();
        ball.update(paddle.rectxXyY());
        
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shape);
        shape.end();
        
        shape.begin(ShapeRenderer.ShapeType.Filled);
        paddle.draw(shape);
        shape.end();
    }
}