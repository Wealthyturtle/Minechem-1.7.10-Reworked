package wealthyturtle.uiesingularities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.avaritia.Avaritia;
import fox.spiteful.avaritia.render.ICosmicRenderItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class EternalSingularityItem
	extends Item
	implements ICosmicRenderItem
{
  public static Item instance;
  private IIcon cosmicMask;
  private IIcon pommel;
  
  public EternalSingularityItem()
  {
    super();
    setUnlocalizedName("eternal_singularity");
    setTextureName("avaritia:singularity");
    setCreativeTab(Avaritia.tab);
  }
  
  public void setDamage(ItemStack stack, int damage)
  {
    super.setDamage(stack, 0);
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon es_getMaskTexture(ItemStack stack, EntityPlayer player)
  {
    return this.cosmicMask;
  }
  
  @SideOnly(Side.CLIENT)
  public float es_getMaskMultiplier(ItemStack stack, EntityPlayer player)
  {
    return 1.0F;
  }
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister es_ir)
  {
    super.registerIcons(es_ir);
    
    this.cosmicMask = es_ir.registerIcon("universalsingularities:eternalsingularity_cosmicMask");
    this.pommel = es_ir.registerIcon("universalsingularities:eternalsingularity_pommel");
  }
  
  public IIcon getIcon(ItemStack stack, int pass)
  {
    if (pass == 1) {
      return this.pommel;
    }
    return super.getIcon(stack, pass);
  }
  
  @SideOnly(Side.CLIENT)
  public boolean requiresMultipleRenderPasses()
  {
    return true;
  }
   
  @SideOnly(Side.CLIENT)
  public boolean hasEffect(ItemStack par1ItemStack, int pass)
  {
    return false;
  }
}
