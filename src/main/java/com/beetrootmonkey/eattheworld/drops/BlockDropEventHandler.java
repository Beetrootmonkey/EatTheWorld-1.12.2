package com.beetrootmonkey.eattheworld.drops;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockDropEventHandler {

	@SubscribeEvent
	public void onBlockDrop(HarvestDropsEvent event) {
//		if (event.getState().getBlock().equals(ModBlocks.oreCopper) && Math.random() < 0.5) {
//			replaceDrop(ModItems.chunkCopper, new ItemStack(ModItems.ingotCopper), event);
//		}
	}


	private void replaceDrop(Item filter, ItemStack replacement, HarvestDropsEvent event) {
		List<ItemStack> toRemove = new ArrayList<ItemStack>();
		for (ItemStack itemStack : event.getDrops()) {
			if (itemStack.getItem().equals(filter)) {
				replacement.setCount(itemStack.getCount());
				toRemove.add(itemStack);
				break;
			}
		}

		if(!toRemove.isEmpty()) {
			event.getDrops().removeAll(toRemove);
			event.getDrops().add(replacement);
		}
	}
}
