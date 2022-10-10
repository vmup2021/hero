import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import javax.swing.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.lanterna.input.KeyType.*;

public class Arena {
    private int height;
    private int width;

    private List<Wall> walls;
    Hero hero = new Hero(10,10);

    Arena(int h, int w){
        this.height = h;
        this.width = w;
        this.walls = createWalls();
    }

    private void moveHero(Position position){
        hero.setPosition(position);
    }

    public void processKey(KeyStroke key){
        switch(key.getKeyType()){
            case ArrowLeft : moveHero(hero.moveLeft()) ; break;
            case ArrowRight: moveHero(hero.moveRight()); break;
            case ArrowUp:  moveHero(hero.moveUp()); break;
            case ArrowDown: moveHero(hero.moveDown()); break;
        }
    }
    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
        for(Wall wall : walls){
            wall.draw(graphics);
        }
        hero.draw(graphics);
    }

    private List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for(int c = 0; c < width; c++){
            walls.add(new Wall(c,0));
            walls.add(new Wall(c, height-1));
        }

        for(int r = 1; r < height -1; r++){
            walls.add(new Wall(0,r));
            walls.add(new Wall(width -1, r));
        }
        return walls;
    }
}
