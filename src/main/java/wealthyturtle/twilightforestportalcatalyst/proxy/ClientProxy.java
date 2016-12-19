package wealthyturtle.twilightforestportalcatalyst.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import wealthyturtle.twilightforestportalcatalyst.TFPCItem;

public final class ClientProxy extends CommonProxy
{
	@Override
	public void init()
	{
		MinecraftForgeClient.registerItemRenderer(TFPCItem.instance, null);
	}

	@Override
	public void postInit()
	{
		super.postInit();
	}
}