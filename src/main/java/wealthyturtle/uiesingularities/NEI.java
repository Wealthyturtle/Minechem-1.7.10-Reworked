package wealthyturtle.uiesingularities;

import codechicken.nei.api.API;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public final class NEI
{
	private NEI() {}

	public static void hide(@Nonnull final ItemStack itemStack)
	{
		API.hideItem(itemStack);
	}
}