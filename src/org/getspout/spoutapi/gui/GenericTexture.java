/*
 * This file is part of Spout API (http://wiki.getspout.org/).
 * 
 * Spout API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Spout API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.getspout.spoutapi.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.getspout.spoutapi.packet.PacketUtil;

public class GenericTexture extends GenericWidget implements Texture {
	protected String url = null;
	public GenericTexture() {
		
	}
	
	@Override
	public int getVersion() {
		return super.getVersion() + 0;
	}
	
	public GenericTexture(String url) {
		this.url = url;
	}

	@Override
	public WidgetType getType() {
		return WidgetType.Texture;
	}
	
	@Override
	public int getNumBytes() {
		return super.getNumBytes() + PacketUtil.getNumBytes(getUrl());
	}
	
	@Override
	public void readData(DataInputStream input) throws IOException {
		super.readData(input);
		this.setUrl(PacketUtil.readString(input));
	}

	@Override
	public void writeData(DataOutputStream output) throws IOException {
		super.writeData(output);
		PacketUtil.writeString(output, getUrl());
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public Texture setUrl(String Url) {
		this.url = Url;
		return this;
	}

}
