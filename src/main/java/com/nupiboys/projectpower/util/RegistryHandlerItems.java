package com.nupiboys.projectpower.util;

import java.util.function.Supplier;

import com.nupiboys.projectpower.ProjectPower;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandlerItems {

    // Items ONLY
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ProjectPower.MOD_ID);

    //Ingots
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SCARIUM_INGOT = ITEMS.register("scarium_ingot", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> BURNIUM_INGOT = ITEMS.register("burnium_ingot", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));

    //Dusts
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SILVER_DUST = ITEMS.register("silver_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SCARIUM_DUST = ITEMS.register("scarium_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> BURNIUM_DUST = ITEMS.register("burnium_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));

    //Tools
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ModItemTier.COPPER, 3, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(ModItemTier.COPPER, 9, 1.3F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(ModItemTier.COPPER, 6, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(ModItemTier.COPPER, 1, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(ModItemTier.COPPER, 2.0F, new Item.Properties().group(ProjectPower.TAB)));

    public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe", () -> new PickaxeItem(ModItemTier.COPPER, 3, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SILVER_AXE = ITEMS.register("silver_axe", () -> new AxeItem(ModItemTier.COPPER, 9, 1.3F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword", () -> new SwordItem(ModItemTier.COPPER, 6, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel", () -> new ShovelItem(ModItemTier.COPPER, 1, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SILVER_HOE = ITEMS.register("silver_hoe", () -> new HoeItem(ModItemTier.COPPER, 2.0F, new Item.Properties().group(ProjectPower.TAB)));

    public static final RegistryObject<Item> ALUMINUM_PICKAXE = ITEMS.register("aluminum_pickaxe", () -> new PickaxeItem(ModItemTier.COPPER, 3, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> ALUMINUM_AXE = ITEMS.register("aluminum_axe", () -> new AxeItem(ModItemTier.COPPER, 9, 1.3F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> ALUMINUM_SWORD = ITEMS.register("aluminum_sword", () -> new SwordItem(ModItemTier.COPPER, 6, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> ALUMINUM_SHOVEL = ITEMS.register("aluminum_shovel", () -> new ShovelItem(ModItemTier.COPPER, 1, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> ALUMINUM_HOE = ITEMS.register("aluminum_hoe", () -> new HoeItem(ModItemTier.COPPER, 2.0F, new Item.Properties().group(ProjectPower.TAB)));

    public static final RegistryObject<Item> BURNIUM_PICKAXE = ITEMS.register("burnium_pickaxe", () -> new PickaxeItem(ModItemTier.COPPER, 3, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> BURNIUM_AXE = ITEMS.register("burnium_axe", () -> new AxeItem(ModItemTier.COPPER, 9, 1.3F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> BURNIUM_SWORD = ITEMS.register("burnium_sword", () -> new SwordItem(ModItemTier.COPPER, 6, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> BURNIUM_SHOVEL = ITEMS.register("burnium_shovel", () -> new ShovelItem(ModItemTier.COPPER, 1, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> BURNIUM_HOE = ITEMS.register("burnium_hoe", () -> new HoeItem(ModItemTier.COPPER, 2.0F, new Item.Properties().group(ProjectPower.TAB)));

    public static final RegistryObject<Item> SCARIUM_PICKAXE = ITEMS.register("scarium_pickaxe", () -> new PickaxeItem(ModItemTier.COPPER, 3, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SCARIUM_AXE = ITEMS.register("scarium_axe", () -> new AxeItem(ModItemTier.COPPER, 9, 1.3F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SCARIUM_SWORD = ITEMS.register("scarium_sword", () -> new SwordItem(ModItemTier.COPPER, 6, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SCARIUM_SHOVEL = ITEMS.register("scarium_shovel", () -> new ShovelItem(ModItemTier.COPPER, 1, 2.0F, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SCARIUM_HOE = ITEMS.register("scarium_hoe", () -> new HoeItem(ModItemTier.COPPER, 2.0F, new Item.Properties().group(ProjectPower.TAB)));

    //Armor
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET, new Item.Properties().group(ProjectPower.TAB)));

    public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register("silver_helmet", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SILVER_LEGGINGS = ITEMS.register("silver_leggings", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SILVER_BOOTS = ITEMS.register("silver_boots", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET, new Item.Properties().group(ProjectPower.TAB)));

    public static final RegistryObject<Item> ALUMINUM_HELMET = ITEMS.register("aluminum_helmet", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> ALUMINUM_CHESTPLATE = ITEMS.register("aluminum_chestplate", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> ALUMINUM_LEGGINGS = ITEMS.register("aluminum_leggings", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> ALUMINUM_BOOTS = ITEMS.register("aluminum_boots", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET, new Item.Properties().group(ProjectPower.TAB)));

    public static final RegistryObject<Item> BURNIUM_HELMET = ITEMS.register("burnium_helmet", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> BURNIUM_CHESTPLATE = ITEMS.register("burnium_chestplate", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> BURNIUM_LEGGINGS = ITEMS.register("burnium_leggings", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> BURNIUM_BOOTS = ITEMS.register("burnium_boots", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET, new Item.Properties().group(ProjectPower.TAB)));

    public static final RegistryObject<Item> SCARIUM_HELMET = ITEMS.register("scarium_helmet", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SCARIUM_CHESTPLATE = ITEMS.register("scarium_chestplate", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SCARIUM_LEGGINGS = ITEMS.register("scarium_leggings", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS, new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SCARIUM_BOOTS = ITEMS.register("scarium_boots", () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET, new Item.Properties().group(ProjectPower.TAB)));

    //Custom Item Tier
    public enum ModItemTier implements IItemTier {
    	//Materials
    	COPPER(2, 230, 5.0F, 1.7F, 13, () -> {
    			return Ingredient.fromItems(RegistryHandlerItems.COPPER_INGOT.get());
      	});
    	/*
    	SILVER(2, 230, 5.0F, 1.7F, 13, () -> {
    		return Ingredient.fromItems(RegistryHandlerItems.SILVER_INGOT.get());
    	});
    	ALUMINUM(2, 230, 5.0F, 1.7F, 13, () -> {
    		return Ingredient.fromItems(RegistryHandlerItems.ALUMINUM_INGOT.get());
    	});
    	SCARIUM(2, 230, 5.0F, 1.7F, 13, () -> {
    		return Ingredient.fromItems(RegistryHandlerItems.SCARIUM_INGOT.get());
    	});
    	BURNIUM(2, 230, 5.0F, 1.7F, 13, () -> {
    		return Ingredient.fromItems(RegistryHandlerItems.BURNIUM_INGOT.get());
    	});
      	*/

    	private final int HARVEST_LEVEL;
    	private final int MAX_USES;
    	private final float EFFICIENCY;
    	private final float ATTACK_DAMAGE;
    	private final int ENCHANTABILITY;
    	private final LazyValue<Ingredient> REPAIR_MATERIAL;

    	ModItemTier(int harvestIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantibilityIn, Supplier<Ingredient> repairMaterialIn) {
    		this.HARVEST_LEVEL = harvestIn;
    		this.MAX_USES = maxUsesIn;
    		this.EFFICIENCY = efficiencyIn;
    		this.ATTACK_DAMAGE = attackDamageIn;
    		this.ENCHANTABILITY = enchantibilityIn;
    		this.REPAIR_MATERIAL = new LazyValue<>(repairMaterialIn);
    	}

		@Override
		public int getMaxUses() {
			return this.MAX_USES;
		}

		@Override
		public float getEfficiency() {
			return this.EFFICIENCY;
		}

		@Override
		public float getAttackDamage() {
			return this.ATTACK_DAMAGE;
		}

		@Override
		public int getHarvestLevel() {
			return this.HARVEST_LEVEL;
		}

		@Override
		public int getEnchantability() {
			return this.ENCHANTABILITY;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.REPAIR_MATERIAL.getValue();
		}
    }

    //Custom Armor Material
    public enum ModArmorMaterial implements IArmorMaterial {
    	//Materials
    	COPPER(ProjectPower.MOD_ID + ":copper_layer",  10, new int[] {2, 4, 3, 1}, 12, SoundEvents.field_226124_Y_, 0.0F, () -> {
    		return Ingredient.fromItems(RegistryHandlerItems.COPPER_INGOT.get());
    	});
      /*
    	SILVER(ProjectPower.MOD_ID + ":silver_layer",  10, new int[] {2, 4, 3, 1}, 12, SoundEvents.field_226124_Y_, 0.0F, () -> {
    		return Ingredient.fromItems(RegistryHandlerItems.SILVER_INGOT.get());
    	});,

    	ALUMINUM(ProjectPower.MOD_ID + ":aluminum_layer",  10, new int[] {2, 4, 3, 1}, 12, SoundEvents.field_226124_Y_, 0.0F, () -> {
    		return Ingredient.fromItems(RegistryHandlerItems.ALUMINUM_INGOT.get());
    	});,

    	SCARIUM(ProjectPower.MOD_ID + ":scarium_layer",  10, new int[] {2, 4, 3, 1}, 12, SoundEvents.field_226124_Y_, 0.0F, () -> {
    		return Ingredient.fromItems(RegistryHandlerItems.SCARIUM_INGOT.get());
    	});,

    	BURNIUM(ProjectPower.MOD_ID + ":burnium_layer",  10, new int[] {2, 4, 3, 1}, 12, SoundEvents.field_226124_Y_, 0.0F, () -> {
    		return Ingredient.fromItems(RegistryHandlerItems.BURNIUM_INGOT.get());
    	});
      */
    	private static final int[] MAX_DAMAGE_ARRAY = new int [] { 8, 8, 8, 8 };
    	private final String NAME;
    	private final int MAX_DAMAGE_FACTOR;
    	private final int[] DAMAGE_REDUCTION_AMOUNT_ARRAY;
    	private final int ENCHANTABILITY;
    	private final SoundEvent SOUND_EVENT;
    	private final float TOUGHNESS;
    	private final LazyValue<Ingredient> REPAIR_MATERIAL;

    	ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
    		this.NAME = nameIn;
    		this.MAX_DAMAGE_FACTOR = maxDamageFactorIn;
    		this.DAMAGE_REDUCTION_AMOUNT_ARRAY = damageReductionAmountIn;
    		this.ENCHANTABILITY = enchantabilityIn;
    		this.SOUND_EVENT = soundEventIn;
    		this.TOUGHNESS = toughnessIn;
    		this.REPAIR_MATERIAL = new LazyValue<>(repairMaterialIn);
    	}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.MAX_DAMAGE_FACTOR;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.DAMAGE_REDUCTION_AMOUNT_ARRAY[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return this.ENCHANTABILITY;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return this.SOUND_EVENT;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public Ingredient getRepairMaterial() {
			return this.REPAIR_MATERIAL.getValue();
		}

		@Override
		public String getName() {
			return this.NAME;
		}

		@Override
		public float getToughness() {
			return this.TOUGHNESS;
		}

    }

}
