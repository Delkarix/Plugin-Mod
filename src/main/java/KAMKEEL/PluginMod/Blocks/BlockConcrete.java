package KAMKEEL.PluginMod.Blocks;

import java.util.List;

import KAMKEEL.PluginMod.Blocks.ItemBlock.ItemBlockConcrete;
import KAMKEEL.PluginMod.LocalizationHelper;
import KAMKEEL.PluginMod.PluginMod;
import KAMKEEL.PluginMod.Util.ColorUtil;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockConcrete extends Block {
    public static final int META_MAX = 15;

    private IIcon[] iicons = new IIcon[META_MAX + 1];

    public BlockConcrete() {
        super(Material.rock);
        this.setHardness(1.8F);
        this.setStepSound(soundTypeStone);
        this.setHarvestLevel("pickaxe", 0);
        this.setCreativeTab(PluginMod.blocksTab);
    }

    public void register() {
        this.setBlockName(LocalizationHelper.MOD_PREFIX + "concrete");
        GameRegistry.registerBlock(this, ItemBlockConcrete.class, "concrete");
    }


    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        for(int meta = 0; meta <= META_MAX; ++meta) {
            iicons[meta] = register.registerIcon(LocalizationHelper.MOD_PREFIX + "concrete_" + ColorUtil.concreteToString(meta));
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return iicons[meta%(META_MAX+1)];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTab, List list) {
        for(int meta = 0; meta <= META_MAX; ++meta) {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }


    @Override
    public MapColor getMapColor(int meta) {
        return ColorUtil.metaToMapColorConcrete(meta);
    }
}