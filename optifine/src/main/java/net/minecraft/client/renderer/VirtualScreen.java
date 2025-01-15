package net.minecraft.client.renderer;

import javax.annotation.Nullable;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Monitor;

public final class VirtualScreen implements AutoCloseable
{
    private final Minecraft mc;
    private final MonitorHandler monitorHandler;

    public VirtualScreen(Minecraft p_i865_1_)
    {
        this.mc = p_i865_1_;
        this.monitorHandler = new MonitorHandler(Monitor::new);
    }

    public MainWindow create(ScreenSize screenSizeIn, @Nullable String videoModeName, String titleIn)
    {
        return new MainWindow(this.mc, this.monitorHandler, screenSizeIn, videoModeName, titleIn);
    }

    public void close()
    {
        this.monitorHandler.close();
    }
}
