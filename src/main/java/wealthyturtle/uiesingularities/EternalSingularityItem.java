package wealthyturtle.uiesingularities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.avaritia.entity.EntityImmortalItem;
import fox.spiteful.avaritia.items.ItemSingularity;
import fox.spiteful.avaritia.items.LudicrousItems;
import fox.spiteful.avaritia.render.ICosmicRenderItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class EternalSingularityItem extends ItemSingularity implements ICosmicRenderItem
{
	private IIcon cosmicMask;

	public EternalSingularityItem()
	{
		super();
		setHasSubtypes(false);
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemstack, int renderpass)
	{
		return 0xFFFFFF;
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

	@Override
	public String getUnlocalizedName(final ItemStack stack)
	{
		return "item.eternalSingularity";
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		super.registerIcons(ir);
		this.cosmicMask = ir.registerIcon("universalsingularities:eternalSingularity_cosmicMask2");
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	@Override
	public boolean hasCustomEntity(ItemStack stack)
	{
		return true;
	}

	@Override
	public Entity createEntity(World world, Entity location, ItemStack itemstack)
	{
		return new EntityImmortalItem(world, location, itemstack);
	}

	@Override
	public void getSubItems(final Item item, final CreativeTabs tab, final List list) {}
}