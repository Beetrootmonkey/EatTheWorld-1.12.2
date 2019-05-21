package com.beetrootmonkey.eattheworld.init;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.beetrootmonkey.eattheworld.client.ModTab;
import com.beetrootmonkey.eattheworld.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MOD_ID, name = Main.MOD_NAME, version = Main.MOD_VERSION, acceptedMinecraftVersions = Main.MC_VERSIONS, guiFactory = Main.GUI_FACTORY)
public class Main {

    public static final ModTab creativeTab = new ModTab();

    public static final String MOD_ID = "eattheworld";
    static final String MOD_NAME = "EatTheWorld";
    static final String MOD_VERSION = "0.1.0";
    static final String MC_VERSIONS = "[1.12.2]";
    static final String GUI_FACTORY = "com.beetrootmonkey.eattheworld.config.ConfigGUIFactory";
    public static final Logger LOG = LogManager.getLogger(MOD_ID);

    @SidedProxy(serverSide = "com.beetrootmonkey.eattheworld.proxy.ServerProxy", clientSide = "com.beetrootmonkey.eattheworld.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Instance(MOD_ID)
    public static Main instance;

    public static final Logger logger = LogManager.getLogger(MOD_ID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
