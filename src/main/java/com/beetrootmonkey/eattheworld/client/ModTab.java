package com.beetrootmonkey.eattheworld.client;

import com.beetrootmonkey.eattheworld.Main;
import com.beetrootmonkey.eattheworld.item.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModTab extends CreativeTabs {

	public ModTab() {
		super(Main.MOD_ID);
		// setBackgroundImageName("tutorialmod.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.cooked_guardian); // shown icon on creative tab
	}

	@Override
	public boolean hasSearchBar() {
		return false; // return false if you don't want search bar
	}

}
