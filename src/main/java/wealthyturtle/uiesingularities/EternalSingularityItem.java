<<<<<<< HEAD
package wealthyturtle.uiesingularities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.avaritia.Avaritia;
import fox.spiteful.avaritia.entity.EntityImmortalItem;
import fox.spiteful.avaritia.items.LudicrousItems;
import fox.spiteful.avaritia.render.IHaloRenderItem;
import fox.spiteful.avaritia.render.ICosmicRenderItem;
import wealthyturtle.uiesingularities.render.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

public class EternalSingularityItem
	extends Item
	implements ICosmicRenderItem
{
	public static Item instance;
	private IIcon cosmicMask;
  
	public EternalSingularityItem()
	{
	  super();
	  setUnlocalizedName("eternalSingularity");
	  setTextureName("avaritia:singularity");
	  setCreativeTab(Avaritia.tab);
	}
	  
	public void setDamage(ItemStack stack, int damage)
	{
	  super.setDamage(stack, 0);
	}
	  
	public EnumRarity getRarity(ItemStack stack)
	{
	  return LudicrousItems.cosmic;
	}
	  
	@SideOnly(Side.CLIENT)
	public IIcon getMaskTexture(ItemStack stack, EntityPlayer player)
	{
	  return this.cosmicMask;
	}
	  
	@SideOnly(Side.CLIENT)
	public float getMaskMultiplier(ItemStack stack, EntityPlayer player)
	{
	  return 1.0F;
	}
	  
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
	  super.registerIcons(ir);
	  this.cosmicMask = ir.registerIcon("universalsingularities:eternalSingularity_cosmicMask2");
	}
	  
	public IIcon getIcon(ItemStack stack, int pass)
	{
	  return super.getIcon(stack, pass);
	}
	  
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
	  return true;
	}
	  
	public boolean hasCustomEntity(ItemStack stack)
	{
	  return true;
	}
	  
	public Entity createEntity(World world, Entity location, ItemStack itemstack)
	{
	  return new EntityImmortalItem(world, location, itemstack);
	}
	  
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack, int pass)
	{
	  return false;
	}
}
