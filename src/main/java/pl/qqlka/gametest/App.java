package pl.qqlka.gametest;

import org.lwjgl.opengl.GL11;

import pl.qqlka.gametest.display.Window;

public class App {
    public static void main(String[] args) {
        Window window = new Window(1280, 720, "Title", true, 4, 5);
        
        while(!window.shouldClose()) {
            window.clear(0.5f, 0.5f, 0.1f, 1.0f);

            window.update();
        }

        window.destroy();
    }
}
