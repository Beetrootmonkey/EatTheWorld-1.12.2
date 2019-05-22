package com.beetrootmonkey.eattheworld.item;

import com.beetrootmonkey.eattheworld.Main;

import net.minecraft.item.Item;

public class ItemBase extends Item implements ItemModelProvider {

	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.creativeTab);
	}

	@Override
	public void registerItemModel() {
		Main.proxy.registerItemRenderer(this, 0, name);
	}

}
