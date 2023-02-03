package net.minecraft.src;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import net.minecraft.client.Minecraft;

public class GuiCredits extends GuiScreen {
	protected GuiScreen parentScreen;
	public boolean a = true;
	protected String screenTitle = "Credits";
	private boolean selected = false;

	public GuiCredits(GuiScreen guiScreen1) {
		this.parentScreen = guiScreen1;
	}

	public void initGui() {
		this.initButtons();
	}

	public void initButtons() {
		this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 6 + 168, "Cancel"));
	}

	protected void actionPerformed(GuiButton button) {
		if (button.yPosition == 0) {
			this.mc.displayGuiScreen(this.parentScreen);
		}
	}

	public void drawScreen(int mouseX, int mouseY, float renderPartialTick) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRenderer, "Developer - liminal", this.width / 2, this.height / 4 - -(5), 0xFFFFFF);
		this.drawCenteredString(this.fontRenderer, "Loading pixel art - mariood", this.width / 2, this.height / 4 - -(20), 0xFFFFFF);
		this.drawCenteredString(this.fontRenderer, "Fixed Audio - buj itself", this.width / 2, this.height / 4 - -(35), 0xFFFFFF);
		this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 0xFFFFFF);
		super.drawScreen(mouseX, mouseY, renderPartialTick);
	}
}
