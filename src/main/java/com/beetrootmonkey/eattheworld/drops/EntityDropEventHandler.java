package com.beetrootmonkey.eattheworld.drops;

public class EntityDropEventHandler {
    // @SubscribeEvent
    // public void onEntityDrop(LivingDropsEvent event) {
    // int amount = 1;
    // // cow, extends EntityAnimal. you could use EntityTameable and so on..
    // if (event.getEntityLiving() instanceof EntityHorse &&
    // ((EntityHorse)event.getEntityLiving()).isAdultHorse()) {
    // amount = (int) (Math.random() * 3 + 1 + event.getLootingLevel());
    // addDrop(new ItemStack(event.getEntity().isBurning() ? ModItems.cooked_horse :
    // ModItems.raw_horse, amount),
    // event);
    //
    // } else if (event.getEntityLiving() instanceof EntitySpider &&
    // event.getEntity().isBurning()) {
    // replaceDrop(Items.SPIDER_EYE, new ItemStack(ModItems.cooked_spider_eye),
    // event);
    //
    // }
    // }

//    private static void addDrop(ItemStack item, LivingDropsEvent event) {
//        if (event != null && item != null && item.stackSize > 0 && item.getItem() != null) {
//            event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX,
//                    event.getEntity().posY, event.getEntity().posZ, item));
//        }
//    }
//
//    private static void replaceDrop(Item filter, ItemStack replacement, LivingDropsEvent event) {
//        for (EntityItem eItem : event.getDrops()) {
//            if (eItem.getEntityItem().getItem().equals(filter)) {
//                int amount = eItem.getEntityItem().stackSize;
//                eItem.setEntityItemStack(replacement);
//                eItem.getEntityItem().stackSize = amount;
//            }
//        }
//    }
}
