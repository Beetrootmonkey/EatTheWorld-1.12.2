package com.beetrootmonkey.eattheworld.item.edible;

import com.beetrootmonkey.eattheworld.Main;
import com.beetrootmonkey.eattheworld.item.ItemModelProvider;
import net.minecraft.item.ItemFood;

public class ItemModFood extends ItemFood implements ItemModelProvider {

	protected String name;
	public ItemModFood(String name, int amount, float saturation) {
		this(name, amount, saturation, false);
	}
	
	public ItemModFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation / amount / 2, isWolfFood);
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
