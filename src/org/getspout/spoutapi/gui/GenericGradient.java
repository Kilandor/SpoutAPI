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

public class GenericGradient extends GenericWidget implements Gradient {
	
	protected Color color1 = new Color(0, 0, 0, 0), color2 = new Color(0, 0, 0, 0);
	
	public GenericGradient() {
		
	}
	
	@Override
	public int getVersion() {
		return super.getVersion() + 0;
	}
	
	public Gradient setTopColor(Color color) {
		this.color1 = color;
		return this;
	}
	
	public Gradient setBottomColor(Color color) {
		this.color2 = color;
		return this;
	}
	
	public Color getTopColor() {
		return this.color1;
	}
	
	public Color getBottomColor() {
		return this.color2;
	}

	@Override
	public WidgetType getType() {
		return WidgetType.Gradient;
	}
	
	@Override
	public int getNumBytes() {
		return super.getNumBytes() + 32;
	}
	
	@Override
	public void readData(DataInputStream input) throws IOException {
		super.readData(input);
		this.setTopColor(PacketUtil.readColor(input));
		this.setBottomColor(PacketUtil.readColor(input));
	}

	@Override
	public void writeData(DataOutputStream output) throws IOException {
		super.writeData(output);
		PacketUtil.writeColor(output, getTopColor());
		PacketUtil.writeColor(output, getBottomColor());
	}
	
	@Override
	public void render() {
		//
	}

}
