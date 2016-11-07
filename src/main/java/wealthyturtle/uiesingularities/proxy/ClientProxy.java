package wealthyturtle.uiesingularities.proxy;

import fox.spiteful.avaritia.render.FancyHaloRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public final class ClientProxy extends CommonProxy
{
	@Override
	public void init()
	{
		final FancyHaloRenderer fancyHaloRenderer = new FancyHaloRenderer();
		singularities.forEach(singularity -> MinecraftForgeClient.registerItemRenderer(singularity, fancyHaloRenderer));
	}
}
