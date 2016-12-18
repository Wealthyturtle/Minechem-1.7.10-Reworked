package wealthyturtle.twilightforestportalcatalyst;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class TFPCItem extends Item {
	public TFPCItem() {
		this.setCreativeTab(getCreativeTab().tabMaterials);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(TwilightForestPortalCatalyst.modid + ":" + this.getUnlocalizedName());
	}
}
