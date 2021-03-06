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
package org.getspout.spoutapi.event.inventory;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryPlayerClickEvent extends InventoryClickEvent{
	private static final long serialVersionUID = 9219553850827660981L;

	public InventoryPlayerClickEvent(Player player, Inventory inventory, InventorySlotType type, ItemStack item, ItemStack cursor, int slot, boolean leftClick, boolean shift, Location location) {
		super("InventoryPlayerClickEvent", player, inventory, type, item, cursor, slot, leftClick, shift, location);
	}
	
	@Override
	protected int convertSlot(int slot) {
		return slot;
	}
}
