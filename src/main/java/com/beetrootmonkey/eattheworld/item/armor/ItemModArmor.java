package com.beetrootmonkey.eattheworld.item.armor;

import com.beetrootmonkey.eattheworld.Main;
import com.beetrootmonkey.eattheworld.item.ItemModelProvider;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemModArmor extends ItemArmor implements ItemModelProvider {

	private String name;

	public ItemModArmor(String name, ArmorMaterial material, EntityEquipmentSlot slot) {
		super(material, 0, slot);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}

	@Override
	public void registerItemModel() {
		Main.proxy.registerItemRenderer(this, 0, name);
	}
}
