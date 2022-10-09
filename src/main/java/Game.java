import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.io.IOException;

public class Game {

    private Screen screen;
    Hero hero = new Hero(10,10);

    Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(40,20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }
    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }
    private void moveHero(Position position){
        hero.setPosition(position);
    }
    private void processKey(KeyStroke key){

        switch(key.getKeyType()){
            case ArrowLeft : moveHero(hero.moveLeft()) ; break;
            case ArrowRight: moveHero(hero.moveRight()); break;
            case ArrowUp:  moveHero(hero.moveUp()); break;
            case ArrowDown: moveHero(hero.moveDown()); break;
        }/*Os methods precisam ser publicos*/
    }
    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') break;
            else if(key.getKeyType() == KeyType.EOF) break;
            processKey(key);
        }
    }
}
