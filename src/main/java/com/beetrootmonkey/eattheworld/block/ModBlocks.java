package com.beetrootmonkey.eattheworld.block;

import com.beetrootmonkey.eattheworld.init.Main;
import com.beetrootmonkey.eattheworld.item.ItemModelProvider;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
    private static Block[] blocks = new Block[]
            {

            };

    public static void register() {
        for (Block block : blocks) {
            register(block);
        }
    }

    private static void register(Block block) {
        ForgeRegistries.BLOCKS.register(block);
        if (block instanceof BlockBase) {
            ForgeRegistries.ITEMS.register(((BlockBase) block).itemBlock);
        }
        if (block instanceof ItemModelProvider) {
            ((ItemModelProvider) block).registerItemModel();

        }
        if (block instanceof BlockBase) {
            Class<? extends TileEntity> clazz = ((BlockBase) block).getTEClass();
            if (clazz != null) {
                GameRegistry.registerTileEntity(clazz, Main.MOD_ID + ":" + clazz.getSimpleName().toLowerCase());
            }
        }
    }
}
