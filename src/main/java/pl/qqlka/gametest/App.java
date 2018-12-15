package pl.qqlka.gametest;

import org.lwjgl.opengl.GL11;

import pl.qqlka.gametest.display.Window;

public class App {
    public static void main(String[] args) {
        Window window = new Window();
        window.init(800, 600, "Hello");
        
        while(!window.shouldClose()) {
            window.clear(0.5f, 0.5f, 0.1f, 1.0f);

            GL11.glBegin(GL11.GL_TRIANGLES);

            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            GL11.glVertex2f(-0.5f, -0.5f);
            GL11.glVertex2f(0.5f, -0.5f);
            GL11.glVertex2f(0.5f, 0.5f);

            GL11.glEnd();

            window.update();
        }

        window.destroy();
    }
}
