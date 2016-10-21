package wealthyturtle.uiesingularities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.avaritia.items.ItemSingularity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

import javax.annotation.Nonnull;
import java.util.List;

public final class UniversalSingularityItem extends ItemSingularity
{
	public final String name;
	public final List<UniversalSingularityWrapper> universalSingularities;

	public UniversalSingularityItem(@Nonnull final String name, @Nonnull final List<UniversalSingularityWrapper> universalSingularities)
	{
		super();
		this.name = name;
		this.universalSingularities = universalSingularities;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getColorFromItemStack(final ItemStack itemstack, final int renderPass)
	{
		final int metadata = getDamage(itemstack);
		return renderPass == 0 ? universalSingularities.get(metadata).dColor : universalSingularities.get(metadata).cColor;
	}

	@Override
	public String getUnlocalizedName(final ItemStack stack)
	{
		return "item.universalSingularities." + name + "." + universalSingularities.get(getDamage(stack)).name;
	}

	@Override
	public int getDamage(final ItemStack itemStack)
	{
		return MathHelper.clamp_int(super.getDamage(itemStack), 0, universalSingularities.size() - 1);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(final Item item, final CreativeTabs tab, final List list)
	{
		for (int i = 0; i < universalSingularities.size(); i++)
			list.add(new ItemStack(item, 1, i));
	}
}