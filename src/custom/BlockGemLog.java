package net.minecraft.src;

import java.util.Random;

public class BlockGemLog extends Block {
	protected BlockGemLog(int id) {
		super(id, Material.wood);
		this.blockIndexInTexture = 76;
	}

	public int quantityDropped(Random rand) {
		return 1;
	}

	public int idDropped(int metadata, Random rand) {
		return Block.gemLog.blockID;
	}

	public int getBlockTextureFromSide(int side) {
		return side == 1 ? 77 : (side == 0 ? 77 : 76);
	}
}
