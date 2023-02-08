package net.minecraft.src;

import net.minecraft.client.Minecraft;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Packet130AfterglowMeta extends Packet {
	public List<ULPPExtension> extensions = new ArrayList<>();
	public String clientName = "Afterglow";
	public String host = "";
	public int[] version = Minecraft.INSTANCE.getVersion();
	public String tag = Minecraft.INSTANCE.getVersionTag();
	public long flags = 0;

	@Override
	public void readPacketData(DataInputStream dataInputStream) throws IOException {
		clientName = dataInputStream.readUTF();
		tag = dataInputStream.readUTF();
		host = dataInputStream.readUTF();
		short verLen = dataInputStream.readShort();
		version = new int[verLen];
		for (short i = 0; i < verLen; i++)
			version[i] = dataInputStream.readShort();
		int count = dataInputStream.readInt();
		extensions.clear();
		for (int i = 0; i < count; i++) {
			ULPPExtension ext = new ULPPExtension(
					dataInputStream.readUTF(),
					dataInputStream.readInt()
			);
			extensions.add(ext);
		}
		flags = dataInputStream.readLong();
	}

	@Override
	public void writePacket(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(clientName);
		dataOutputStream.writeUTF(tag);
		dataOutputStream.writeUTF(host);
		dataOutputStream.writeShort(version.length);
		for (int i : version) {
			dataOutputStream.writeShort(i);
		}
		dataOutputStream.writeInt(extensions.size());
		for (ULPPExtension ext : extensions) {
			dataOutputStream.writeUTF(ext.getName());
			dataOutputStream.writeInt(ext.getVersion());
		}
		dataOutputStream.writeLong(flags);
	}

	public Packet130AfterglowMeta Default() {
		this.extensions.clear();
		this.extensions.add(new ULPPExtension("ULPP", 1));
		this.extensions.add(new ULPPExtension("AFTERGLOW", 2));

		this.version = Minecraft.INSTANCE.getVersion();
		this.tag = Minecraft.INSTANCE.getVersionTag();

		this.clientName = "Afterglow";
		this.flags = 0;

		return this;
	}

	@Override
	public void processPacket(NetHandler netHandler) {
		netHandler.handleAfterglowMeta(this);
	}

	@Override
	public int getPacketSize() {
		int len = 20 + clientName.length() + tag.length() + version.length * 2 + host.length();
		for (ULPPExtension ext : extensions) {
			len += 6 + ext.getName().length();
		}
		return len;
	}

	public AfterglowMeta getMeta() {
		return new AfterglowMeta(clientName, version, tag, flags);
	}
}