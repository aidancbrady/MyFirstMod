package myfirstmod.client;

import myfirstmod.common.CommonProxy;

/**
 * The client-only side of your mod's proxy. More information about the way proxies work can be found in the
 * CommonProxy class's javadoc.
 * @author aidancbrady
 *
 */
public class ClientProxy extends CommonProxy
{
	/*
	 * Actually do the renderer registration. Note the @Override annotation- this is not required, and simply
	 * exists as good coding practice when overriding methods.
	 */
	@Override
	public void registerRenderers()
	{
		//Renderer registration!
	}
}
