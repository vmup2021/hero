import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import jdk.nashorn.internal.ir.Terminal;

public class Hero {
    private Position position = new Position(10,10);
    Hero(int x, int y){
        position.setX(x);
        position.setY(y);
    }
    public void setPosition(Position p){
        position.setX(p.getX());
        position.setY(p.getY());
    }
    public Position moveUp(){
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveDown(){
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveRight(){
        return new Position(position.getX() + 1, position.getY());
    }
    public Position moveLeft(){
        return new Position(position.getX() - 1, position.getY());
    }

    public void draw(TextGraphics graphics){
        graphics.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()),"X");
    }


}
