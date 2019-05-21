package com.beetrootmonkey.eattheworld.item.materials;

import com.beetrootmonkey.eattheworld.init.Main;
import com.beetrootmonkey.eattheworld.item.ModItems;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModArmorMaterials {
//	public static final ArmorMaterial COPPER = initialize(EnumHelper.addArmorMaterial("COPPER", Main.MOD_ID + ":copper", 15,
//			new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F), ModItems.ingotCopper);

	
	public static ArmorMaterial initialize(ArmorMaterial material, ItemStack repairItem) {
		material.repairMaterial = repairItem;
		return material;
	}
}
