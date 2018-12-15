package pl.qqlka.gametest.display;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

public class Window {
    private long windowHandle;
    boolean isInitialized;

    public Window() {
        isInitialized = false;
    }

    public void init(int width, int height, String title) throws RuntimeException {
        if(GLFW_NOT_INITIALIZED != 0)
            glfwInit();

        glfwDefaultWindowHints();

        windowHandle = glfwCreateWindow(width, height, title, 0, 0);
        if(windowHandle == 0) {
            throw new RuntimeException("Cannot create glfw window");
        }
        glfwMakeContextCurrent(windowHandle);

        isInitialized = true;
        GL.createCapabilities();
    }

    public void init(int width, int height, String title, int glMajorVersion, int glMinorVersion) throws RuntimeException {
        if(GLFW_NOT_INITIALIZED != 0)
            glfwInit();

        glfwDefaultWindowHints();

        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, glMajorVersion);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, glMinorVersion);

        windowHandle = glfwCreateWindow(width, height, title, 0, 0);
        if(windowHandle == 0) {
            throw new RuntimeException("Cannot create glfw window");
        }
        glfwMakeContextCurrent(windowHandle);

        isInitialized = true;
        GL.createCapabilities();
    }

    public boolean shouldClose() {
        if(isInitialized) {
            return glfwWindowShouldClose(windowHandle);
        } else {
            return true;
        }
    }

    public void update() {
        if(isInitialized) {
            glfwSwapBuffers(windowHandle);
            glfwPollEvents();
        }
    }

    public void destroy() {
        if(isInitialized) {
            glfwDestroyWindow(windowHandle);
        }
    }

    public void clear(float red, float green, float blue, float alpha) {
        if(isInitialized) {
            glClearColor(red, green, blue, alpha);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        }
    }
}