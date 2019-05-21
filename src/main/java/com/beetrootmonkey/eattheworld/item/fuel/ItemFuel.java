package com.beetrootmonkey.eattheworld.item.fuel;

import com.beetrootmonkey.eattheworld.item.ItemBase;

import net.minecraft.item.ItemStack;

public class ItemFuel extends ItemBase {
	int burnTime;

	@Override
	public int getItemBurnTime(ItemStack itemStack) {
		return burnTime;
	}

	public ItemFuel(String name, int burnTime) {
		super(name);
		this.burnTime = burnTime;
	}
}
