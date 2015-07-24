package myfirstmod.common;

/**
 * This is the proxy class that can contain code shared between both the client and server. This kind of stuff
 * can get complicated so I'll provide a few examples.
 * 
 * A mod's proxy is a collection of two core classes- the client proxy and the common proxy- that work together
 * to isolate code that should only be run on the client. The usual and recommended way to accomplish this is to
 * define methods in this class (the common, or shared, proxy) and override them in the client proxy to add
 * client-only interaction. 
 * 
 * For example, let's say we want to register some fancy renderers for a block; we wouldn't want that to be called
 * on the server code (there's no rendering on the server!). I usually accomplish this by defining a method like 
 * "registerRenderers()" in the common proxy (but leaving the implementation blank), and then override the method
 * in the client proxy with the actual registrations. The example is included in-code if you want to take a look.
 * @author aidancbrady
 *
 */
public class CommonProxy
{
	/**
	 * Register this mod's client-only renderers. This should be defined in CommonProxy and overridden in ClientProxy.
	 */
	public void registerRenderers() {}
}
