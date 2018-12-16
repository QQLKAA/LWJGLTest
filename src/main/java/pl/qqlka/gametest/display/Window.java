package pl.qqlka.gametest.display;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

public class Window {
    private long windowHandle;

    public Window(int width, int height, String title) throws RuntimeException {
        glfwInit();
        glfwDefaultWindowHints();

        createWindow(width, height, title, false);
    }

    public Window(int width, int height, String title, boolean fullscreen) throws RuntimeException {
        glfwInit();
        glfwDefaultWindowHints();

        createWindow(width, height, title, fullscreen);
    }

    public Window(int width, int height, String title, int glMajorVersion, int glMinorVersion) throws RuntimeException {
        glfwInit();
        glfwDefaultWindowHints();

        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, glMajorVersion);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, glMinorVersion);

        createWindow(width, height, title, false);
    }

    public Window(int width, int height, String title, boolean fullscreen, int glMajorVersion, int glMinorVersion) {
        glfwInit();
        glfwDefaultWindowHints();

        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, glMajorVersion);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, glMinorVersion);

        createWindow(width, height, title, fullscreen);
    }

    private void createWindow(int width, int height, String title, boolean fullscreen) throws RuntimeException {
        long monitor = 0;

        if(fullscreen) {
            monitor = glfwGetPrimaryMonitor();
        }

        windowHandle = glfwCreateWindow(width, height, title, monitor, 0);
        if(windowHandle == 0) {
            throw new RuntimeException("Cannot create window");
        }
        glfwMakeContextCurrent(windowHandle);

        GL.createCapabilities();
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(windowHandle);
    }

    public void update() {
        glfwSwapBuffers(windowHandle);
        glfwPollEvents();
    }

    public void destroy() {
        glfwDestroyWindow(windowHandle);
    }

    public void clear(float red, float green, float blue, float alpha) {
        glClearColor(red, green, blue, alpha);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }
}
