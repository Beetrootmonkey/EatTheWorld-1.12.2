package com.beetrootmonkey.eattheworld.item.tools;

import com.beetrootmonkey.eattheworld.Main;
import com.beetrootmonkey.eattheworld.item.ItemModelProvider;

import net.minecraft.item.ItemAxe;

public class ItemModAxe extends ItemAxe implements ItemModelProvider {

	protected String name;

	public ItemModAxe(String name, ToolMaterial material, float damage, float speed) {
		super(material, damage, speed);
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
