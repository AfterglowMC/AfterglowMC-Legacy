package net.minecraft.src;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import net.minecraft.client.Minecraft;

public class GuiWorldConfig extends GuiScreen {
	protected GuiScreen parentScreen;
	public boolean a = true;
	private String i = "";
	protected String screenTitle = "World Configuration";
	private boolean selected = false;

	public int latest = net.minecraft.src.GuiSelectWorld.latest;

	public GuiWorldConfig(GuiScreen guiScreen1) {
		this.parentScreen = guiScreen1;
	}

	public void initGui() {
		this.initButtons();
	}

	public void initButtons() {
		this.controlList.add(new GuiSmallestButton(100, this.width / 2 - 155, this.height / 6 + (-25), "X"));
		this.controlList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, "Create"));
	}

	protected void actionPerformed(GuiButton button) {
		if(button.yPosition == 100) {
			this.mc.displayGuiScreen(this.parentScreen);
		}

		if(button.yPosition == 200) {
			this.mc.playerController = new PlayerControllerSP(this.mc);
			this.mc.startWorld("World" + latest);
			this.mc.displayGuiScreen((GuiScreen)null);
		}
	}

	public void drawScreen(int mouseX, int mouseY, float renderPartialTick) {
		this.drawOptionBackground();
		this.drawCenteredString(this.fontRenderer, "This isnt finished yet", this.width / 2, this.height / 4 -(-5), 0xFFFFFF);
		this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 0xFFFFFF);
		super.drawScreen(mouseX, mouseY, renderPartialTick);
	}
}
