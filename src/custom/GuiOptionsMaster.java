package net.minecraft.src;

public class GuiOptionsMaster extends GuiScreen {
	protected GuiScreen parentScreen;
	public boolean a = true;
	protected String screenTitle = "Options Master Menu";
	private boolean selected = false;
	public int u = 3;
	public int numberOfOptions = 2;

	public GuiOptionsMaster(GuiScreen guiScreen1) {
		this.parentScreen = guiScreen1;
	}

	public String j(int menu) {
		return menu == 0 ? "General Settings" : menu == 1 ? "Controls" : menu == 2 ? "Dev menu" : "";
	}

	public void initGui() {
		this.initButtons();
	}

	public void initButtons() {
		for(int i1 = 0; i1 < this.u; ++i1) {
			this.controlList.add(new GuiSmallButton(i1, this.width / 2 - 155 + i1 % 2 * 160, this.height / 6 + 24 * (i1 >> 1), this.j(i1)));
		}
		this.controlList.add(new GuiSmallerButton(200, this.width / 2 - 155, this.height / 6 + (-25), "Done"));
	}

	protected void actionPerformed(GuiButton button) {
		if(button.yPosition == 200) {
			this.mc.displayGuiScreen(this.parentScreen);
		}

		if(button.yPosition == 0) {
			this.mc.displayGuiScreen(new GuiOptions(this, this.mc.options));
		}

		if(button.yPosition == 1) {
			this.mc.displayGuiScreen(new GuiControls(this, this.mc.options));
		}

		if(button.yPosition == 2) {
			this.mc.displayGuiScreen(new GuiMasterMenu(this));
		}
	}

	public void drawScreen(int mouseX, int mouseY, float renderPartialTick) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 0xFFFFFF);
		super.drawScreen(mouseX, mouseY, renderPartialTick);
	}

}