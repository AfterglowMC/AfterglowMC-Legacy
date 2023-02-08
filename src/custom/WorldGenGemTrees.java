package net.minecraft.src;

import java.util.Random;

public class WorldGenGemTrees extends WorldGenerator {
	public boolean generate(World world1, Random random2, int i3, int i4, int i5) {
		int i6 = random2.nextInt(2) + 3;
		boolean z7 = true;
		if(i4 >= 1 && i4 + i6 + 1 <= 128) {
			int i8;
			int i10;
			int i11;
			int i12;
			for(i8 = i4; i8 <= i4 + 1 + i6; ++i8) {
				byte b9 = 1;
				if(i8 == i4) {
					b9 = 0;
				}

				if(i8 >= i4 + 1 + i6 - 2) {
					b9 = 2;
				}

				for(i10 = i3 - b9; i10 <= i3 + b9 && z7; ++i10) {
					for(i11 = i5 - b9; i11 <= i5 + b9 && z7; ++i11) {
						if(i8 >= 0 && i8 < 128) {
							i12 = world1.a(i10, i8, i11);
							if(i12 != 0 && i12 != Block.gemLeaves.blockID) {
								z7 = false;
							}
						} else {
							z7 = false;
						}
					}
				}
			}

			if(!z7) {
				return false;
			} else {
				i8 = world1.a(i3, i4 - 1, i5);
				if((i8 == Block.v.blockID || i8 == Block.dirt.blockID) && i4 < 128 - i6 - 1) {
					world1.setBlock(i3, i4 - 1, i5, Block.dirt.blockID);

					int i16;
					for(i16 = i4 - 3 * i6; i16 <= i4 + i6; ++i16) {
						i10 = i16 - (i4 + i6);
						i11 = 1 + i10 / 2;

						for(i12 = i3 - i11; i12 <= i3 + i11; ++i12) {
							int i13 = i12 - i3;

							for(int i14 = i5 - i11; i14 <= i5 + i11; ++i14) {
								int i15 = i14 - i5;
								if((Math.abs(i13) != i11 || Math.abs(i15) != i11 || random2.nextInt(2) != 0 && i10 != 0) && !Block.opaqueCubeLookup[world1.a(i12, i16, i14)]) {
									world1.setBlock(i12, i16, i14, Block.gemLeaves.blockID);
								}
							}
						}
					}

					for(i16 = 0; i16 < i6; ++i16) {
						i10 = world1.a(i3, i4 + i16, i5);
						if(i10 == 0 || i10 == Block.gemLeaves.blockID) {
							world1.setBlock(i3, i4 + i16, i5, Block.gemLog.blockID);
						}
					}

					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
}
