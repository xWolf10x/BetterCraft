package xWolf10x.bettercraft;

@Mod(modid="xWolf10x.bettercraft", name="Better Craft Mod", version="0.1.0")
@NetworkMod(clientSideRequired=true)
public class BetterCraft {

        // The instance of your mod that Forge uses.
        @Instance(value = "xWolf10x.bettercraft")
        public static BetterCraft instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="xWolf10x.bettercraft.client.ClientProxy", serverSide="xWolf10x.bettercraft.CommonProxy")
        public static CommonProxy proxy;
                
        //Registrations
        public static Item rodDiamond;
        
        @EventHandler // used in 1.6.4
        public void preInit(FMLPreInitializationEvent event) {
        
        }
        
        @EventHandler // used in 1.6.4
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                //Registrations Item
                rodDiamond = new RodDiamond(5002).setUnlocalizedName("rodDiamond").setCreativeTab(CreativeTabs.tabMisc);
                GameRegistry.registerItem(rodDiamond, "rodDiamond");
                LanguageRegistry.addName(rodDiamond, "Diamond Rod");
                
                GameRegistry.addRecipe(new ItemStack(Item.leather), "###", "###", "###",
                		'#', Item.rottenFlesh);
                GameRegistry.addRecipe(new ItemStack(Item.saddle), " # ", "# #", "# #",
                		'#', Item.leather);
                GameRegistry.addRecipe(new ItemStack(Item.pocketSundial), "$@$", "###",
                		'$', Item.ingotGold,
                		'@', Item.redstone,
                		'#', Block.stone);
                GameRegistry.addRecipe(new ItemStack(Item.compass), "$@$", "###",
                		'$', Item.ingotIron,
                		'@', Item.redstone,
                		'#', Block.stone);
                GameRegistry.addShapelessRecipe(new ItemStack(Item.gunpowder, 1), new Object[]{
                		Block.cobblestone,
                		Item.flint});
        }
        
        @EventHandler // used in 1.6.4
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
        
        //Commands
        @EventHandler
        public void serverStarting(FMLServerStartingEvent event)
        {
        	CommandHandler commandManager = (CommandHandler)event.getServer().getCommandManager();
            commandManager.registerCommand(new CommandSeed());
            commandManager.registerCommand(new CommandHome());
            commandManager.registerCommand(new CommandNoon());
            commandManager.registerCommand(new CommandMidnight());
            commandManager.registerCommand(new CommandRain());
            commandManager.registerCommand(new CommandClear());
            commandManager.registerCommand(new CommandButcher());
        }
}