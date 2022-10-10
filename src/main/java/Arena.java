import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import javax.swing.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import static com.googlecode.lanterna.input.KeyType.*;

public class Arena {
    private int height;
    private int width;
    Hero hero = new Hero(10,10);

    Arena(int h, int w){
        this.height = h;
        this.width = w;
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
        hero.draw(graphics);
    }

}
