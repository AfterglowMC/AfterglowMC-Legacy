package net.minecraft.src;

import java.io.File;

import net.minecraft.client.Minecraft;

public class GuiPreloads extends GuiScreen {
	protected GuiScreen parentScreen;
	public boolean a = true;
	protected String screenTitle = "Preload Worlds";
	private boolean selected = false;

	public GuiPreloads(GuiScreen guiScreen1) {
		this.parentScreen = guiScreen1;
	}

	public void initGui() {
		this.controlList.add(new GuiButton(1, this.width / 2 - 100, this.height / 6 + 24, "Secret World"));
		this.controlList.add(new GuiButton(2, this.width / 2 - 100, this.height / 6 + 48, "Hub Entrance"));
		this.controlList.add(new GuiButton(3, this.width / 2 - 100, this.height / 6 + 72, "- empty -"));
		this.controlList.add(new GuiButton(4, this.width / 2 - 100, this.height / 6 + 96, "- empty -"));
		this.controlList.add(new GuiButton(5, this.width / 2 - 100, this.height / 6 + 120, "- empty -"));
		this.initButtons();
	}

	public void initButtons() {
		this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 6 + 168, "Cancel"));
	}

	protected void actionPerformed(GuiButton button) {
		if(button.yPosition == 0) {
			this.mc.displayGuiScreen(this.parentScreen);
		}

		if(button.yPosition == 1) {
			this.mc.playerController = new PlayerControllerSP(this.mc);
			this.mc.startWorld("SecretWorld");
			this.mc.displayGuiScreen((GuiScreen)null);
		}

		if(button.yPosition == 2) {
			this.mc.playerController = new PlayerControllerSP(this.mc);
			this.mc.startWorld("Hub");
			this.mc.displayGuiScreen((GuiScreen)null);
		}
	}
	
	public void drawScreen(int mouseX, int mouseY, float renderPartialTick) {
		this.drawOptionBackground();
		this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 0xFFFFFF);
		super.drawScreen(mouseX, mouseY, renderPartialTick);
	}
}