package myfirstmod.common;

import java.util.logging.Logger;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * The highest-level mod declaration- this annotation tells the Minecraft Forge class loader that this class is your mod's main class,
 * and to add it to the load list. Note where the mod ID and version are defined - both are referenced from within the MyFirstMod class
 * structure.
 * @author aidancbrady
 *
 */
@Mod(modid = MyFirstMod.MODID, version = MyFirstMod.VERSION)
public class MyFirstMod 
{
	/**
	 * A never-changing (final) variable representing the *internal* name of this mod. Proper notation is your mod's name, stripped of
	 * special characters and spaces, title-cased. Change this to match your mod's name!
	 */
	public static final String MODID = "MyFirstMod";
	
	/**
	 * Another never-changing (final) variable representing the current version of your mod, NOT the Minecraft version. You should
	 * change this every time you update your mod.
	 */
	public static final String VERSION = "1.0.0";
	
	/**
	 * An instance of your main mod class. Minecraft Forge works with Minecraft mods in a 'singleton' programming design structure,
	 * where only one instance of your mod is used throughout the entire runtime. Minecraft Forge will create the instance for you
	 * and associate it with this variable. Note how it is associated with the mod ID you declared above. You shouldn't need to 
	 * reference this separately in your mod.
	 */
	@Instance(MODID)
	public static MyFirstMod instance;
	
	/**
	 * This mod's 'proxy' object; this is used to separate client-only code with code shared with both the client and server (common).
	 * An instance of 'CommonProxy' will be created and assigned to the 'proxy' variable by Minecraft Forge. You will likely not need
	 * to worry about editing these in most simple mods. Though this is not technically required, it is a core part of any mod you
	 * plan on using in a multiplayer environment- I like to create it just in case I end up needing it.
	 */
	@SidedProxy(clientSide = "myfirstmod.client.ClientProxy", serverSide = "myfirstmod.common.CommonProxy")
	public static CommonProxy proxy;
	
	/**
	 * This mod's Configuration object, used to both to read and write config properties. Note that Minecraft Forge will NOT create and
	 * assign a new Configuration instance for you- in this case, I do it manually in the 'preInit()' method. This is not required, simply
	 * provided for convenience.
	 */
	public static Configuration configuration;
	
	/**
	 * This creates a fancy instance of the 'Logger' class straight from Java's logging libraries, just for this mod (note the reference to
	 * the mod ID). This allows you to log things with varying importance, from simple debug messages to sinister-looking red error messages.
	 * Note that this is not essential for your mod, it simply makes it easier to provide descriptive logs (which can be helpful when trying
	 * to find and fix bugs).
	 */
	public static Logger logger = Logger.getLogger(MODID);
	
	/* PUT YOUR ITEM AND BLOCK DECLARATIONS BELOW! */
	
	/* END VARIABLE DECLARATIONS, START INITIALIZATION METHODS! */
	
	/**
	 * This method is called by Forge just before primary game and mod initialization begins. You can register your items and blocks either
	 * here or in the init() method, but there are certain things that should be done explicitly here, such as register your configuration
	 * file (already done below). Note the '@EventHandler' annotation - this tells Forge that it should remember to add this method to the
	 * event handler's method call list, and the 'FMLPreInitializationEvent' parameter declaration defines it to be called during the
	 * preInit() stage. Don't worry about the technical side of this, though- just think of it as magic :)
	 * @param event - the pre-initialization event passed by Forge
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger.info("Entering pre-initialization phase!");
		
		//Create a new configuration file in the location suggested by Forge (this is always '<modid>.cfg' in the Minecraft install's
		//config directory by default).
		configuration = new Configuration(event.getSuggestedConfigurationFile());
	}
	
	/**
	 * This method is called by Forge during the primary initialization stage of the primary game and other mods. This is a good spot to throw
	 * the bulk of your mod's core initializations, and really anything else that should happen when the mod is loading. This is called the same
	 * way preInit() is called- a mix of the '@EventHandler' annotation and the FMLInitializationEvent parameter declaration.
	 * @param event - the initialization event passed by Forge
	 */
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		logger.info("Entering initialization phase!");
	}
	
	/**
	 * Another initialization method, called when Forge has finished the primary initialization stage and is almost done loading. This is where
	 * you should attempt to do any integration with other mods you have in mind - otherwise, this method should be generally unused. The method
	 * is called by Minecraft Forge just like preInit() and init() above.
	 * @param event - the post initialization event passed by Forge
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		logger.info("Entering post-initialization phase!");
	}
}
