// Reference for Lanterna 3: https://github.com/mabe02/lanterna/blob/master/docs/contents.md
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Arrays;



public class ConwaysLife {
    static TextColor yellow = new TextColor.RGB(141,200,252);
    static TextColor green =  new TextColor.RGB(3, 201, 0);
    static TextColor pink = new TextColor.RGB(217, 0, 255);
    static TextColor blue = new TextColor.RGB(0, 217, 255);

    public static TextColor[] colors = {
            yellow,
        green,
        pink,
        blue
    };

    public static void main(String[] args) {

        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            terminal.setBackgroundColor(new TextColor.RGB(141,200,252));
            Screen screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();
            TerminalSize size = screen.getTerminalSize();
//            graphics.setBackgroundColor(new TextColor.RGB(0, 213, 255));
            graphics.setForegroundColor(new TextColor.RGB(245, 242, 66));
            LifeSimulator simulation = new LifeSimulator(size.getColumns(), size.getRows());
//            simulation.insertPattern(new PatternAcorn(), 20, 15);
            Thread.sleep(200);
            simulation.insertPattern(new PatternBlinker(), 2, 2);
            simulation.insertPattern(new PatternBlinker(), 2, 20);
            simulation.insertPattern(new PatternBlinker(), 70, 2);
            simulation.insertPattern(new PatternBlinker(), 70, 20);
            simulation.insertPattern(new PatternBlock(),35,10);

            screen.startScreen();
            screen.setCursorPosition(null);

            int iterations = 800;
            for (int i = 0; i < iterations; i++) {
                if (i % 4 ==0) {
                    setRandomColor(graphics);
                }
                if (i % 5 ==0) {
                    simulation.insertPattern(new PatternGlider(),5,5);
                }
                //stage one
                if (i == (iterations)/8) {
//                    graphics.setForegroundColor(new TextColor.RGB(3, 201, 0));
                    simulation.insertPattern(new PatternGlider(),25,1);
                    simulation.insertPattern(new PatternGlider(),25,10);
                    simulation.insertPattern(new PatternGlider(),25,20);
                }
                //stage two
                if (i == (iterations)/6) {
                    simulation.insertPattern(new PatternAcorn(), 35, 10);
                }
                //stage three
                if (i == (iterations)/2){
//                    graphics.setForegroundColor(new TextColor.RGB(255, 0, 0));
                    simulation.insertPattern(new PatternAcorn(), 35, 10);
                }
                render(simulation, screen, graphics);   // Render the current state of the simulation
                Thread.yield();                         // Let the JVM have some time to update other things
                Thread.sleep(25);                // Sleep for a bit to make for a nicer paced animation
                simulation.update();                    // Tell the simulation to update
            }

            screen.stopScreen();
        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }

    public static void render(LifeSimulator sim, Screen screen, TextGraphics graphics) {

            Coordinate[] aliveCells = sim.getAliveCells();
                for (int c = 0; c< aliveCells.length; c++) {
                    graphics.setCharacter(aliveCells[c].xpos, aliveCells[c].ypos, 'O');
                    try {
                        screen.refresh();
                    } catch (Exception ex) {
                    }
                }

        screen.clear();
    }

    public static void setRandomColor(TextGraphics graphics){
        int newColor = ThreadLocalRandom.current().nextInt(0, 3 + 1);;
        graphics.setForegroundColor(colors[newColor]);
    }

}
