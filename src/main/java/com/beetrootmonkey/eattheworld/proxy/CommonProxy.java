package com.beetrootmonkey.eattheworld.proxy;

import com.beetrootmonkey.eattheworld.block.ModBlocks;
import com.beetrootmonkey.eattheworld.config.ModConfig;
import com.beetrootmonkey.eattheworld.crafting.ModRecipes;
import com.beetrootmonkey.eattheworld.crafting.RecipeUtils;
import com.beetrootmonkey.eattheworld.drops.BlockDropEventHandler;
import com.beetrootmonkey.eattheworld.drops.EntityDropEventHandler;
import com.beetrootmonkey.eattheworld.drops.LootTableLoadEventHandler;
import com.beetrootmonkey.eattheworld.Main;
import com.beetrootmonkey.eattheworld.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.beetrootmonkey.eattheworld.Main.MOD_ID;

@EventBusSubscriber
public abstract class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(ModConfig.class);
        MinecraftForge.EVENT_BUS.register(LootTableLoadEventHandler.class);
    }

    public void init(FMLInitializationEvent event) {
        ConfigManager.sync(MOD_ID, Type.INSTANCE);
        MinecraftForge.EVENT_BUS.register(ModConfig.class);
        MinecraftForge.EVENT_BUS.register(EntityDropEventHandler.class);
        MinecraftForge.EVENT_BUS.register(BlockDropEventHandler.class);
        LootTableList.register(new ResourceLocation(Main.MOD_ID, "/entities/villager"));
    }

    public void postInit(FMLPostInitializationEvent event) {
        RecipeUtils.doRemoval();
    }

    abstract public boolean isDedicatedServer();

    public abstract void registerItemRenderer(Item item, int meta, String id);

    @SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
        ModBlocks.register();
    }

    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
        ModItems.register();
    }

    @SubscribeEvent
    public static void registerRecipes(Register<IRecipe> event) {
        ModItems.registerOres();
        ModRecipes.register();
    }
}