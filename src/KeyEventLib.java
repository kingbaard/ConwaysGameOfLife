//import java.lang.InterruptedException;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//
//public class KeyEventLib implements KeyListener {
//
//    boolean gPressed;
//    boolean aPressed;
//    boolean bPressed;
//    boolean lPressed;
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//        System.out.println("Key typed");
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//        System.out.println("Key released");
//        int keyCode = e.getKeyCode();
//        char keyChar = (char) keyCode;
//        switch (keyChar) {
//            case 'a': aPressed = true;
//                Thread.yield();
//                aPressed = false;
//            case 'g': gPressed = true;
//                Thread.yield();
//                gPressed = false;
//            case 'b': bPressed = true;
//                Thread.yield();
//                bPressed = false;
//            case 'l': lPressed = true;
//                Thread.yield();
//                lPressed = false;
//        }
//
//    }
//}
