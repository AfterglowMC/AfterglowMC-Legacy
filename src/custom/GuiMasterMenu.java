package net.minecraft.src;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import net.minecraft.client.Minecraft;

public class GuiMasterMenu extends GuiScreen {
	protected GuiScreen parentScreen;
	public boolean a = true;
	protected String screenTitle = "Dev Menu";
	private boolean selected = false;

	public GuiMasterMenu(GuiScreen guiScreen1) {
		this.parentScreen = guiScreen1;
	}

	public void initGui() {
		this.initButtons();
	}

	public void initButtons() {
		this.controlList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 - 0, "World Config"));
		this.controlList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 24, "Fun Options"));
		this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 6 + 168, "Cancel"));
	}

	protected void actionPerformed(GuiButton button) {
		if(button.yPosition == 0) {
			this.mc.displayGuiScreen(this.parentScreen);
		}

		if(button.yPosition == 1) {
			this.mc.displayGuiScreen(new GuiWorldConfig(this));
		}

		if(button.yPosition == 2) {
			this.mc.displayGuiScreen(new GuiFunOptions(this, this.mc.options));
		}
	}

	public void drawScreen(int mouseX, int mouseY, float renderPartialTick) {
		this.drawOptionBackground();
		this.drawCenteredString(this.fontRenderer, "Menus that cant be accesed normally", this.width / 2, this.height / 4 - 20, 0xFFFFFF);
		this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 0xFFFFFF);
		super.drawScreen(mouseX, mouseY, renderPartialTick);
	}
}
