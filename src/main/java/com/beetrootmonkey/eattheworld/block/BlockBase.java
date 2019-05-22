package com.beetrootmonkey.eattheworld.block;

import com.beetrootmonkey.eattheworld.Main;
import com.beetrootmonkey.eattheworld.item.ItemModelProvider;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

public class BlockBase extends Block implements ItemModelProvider {

	protected String name;
	protected ItemBlock itemBlock;

	public BlockBase(Material materialIn, String name) {
		super(materialIn);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.creativeTab);

		itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(name);
		itemBlock.setUnlocalizedName(name);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public void registerItemModel() {
		Main.proxy.registerItemRenderer(itemBlock, 0, name);
	}

	Class<? extends TileEntity> getTEClass() {
		return null;
	}

}
