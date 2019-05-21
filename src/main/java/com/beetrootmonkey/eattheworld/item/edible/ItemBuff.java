package com.beetrootmonkey.eattheworld.item.edible;

import com.beetrootmonkey.eattheworld.item.ItemModelProvider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBuff extends ItemModFood implements ItemModelProvider {

    //	private List<PotionEffect> effects;
    private PotionEffect effect;
    protected float chance;

    @Override
    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);
        if (!world.isRemote && Math.random() < chance) {
            player.addPotionEffect(effect);
        }
    }

    public ItemBuff(String name, int amount, float saturation, PotionEffect effect, float chance) {
        super(name, amount, saturation);
        this.effect = effect;
        this.chance = chance;
    }
}
