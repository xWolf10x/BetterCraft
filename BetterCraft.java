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
        
        }
        
        @EventHandler // used in 1.6.4
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
        
        //Commands
        @EventHandler
        public void serverStarting(FMLServerStartingEvent event)
        {
        
        }
}