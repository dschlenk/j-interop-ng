/**j-Interop (Pure Java implementation of DCOM protocol)  
 * Copyright (C) 2006  Vikram Roopchand
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * Though a sincere effort has been made to deliver a professional, 
 * quality product,the library itself is distributed WITHOUT ANY WARRANTY; 
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.jinterop.dcom.core;


/**Stores the oxid details in memory.
 * 
 * @since 1.0
 *
 */
final class JIComOxidDetails {

	private JILocalCoClass referent = null;
	private String ipid = null;
	private JIOxid oxid = null;
	private JIObjectId oid = null;
	private String iid = null;
	private JIInterfacePointer ptr = null;
	private JIComOxidRuntimeHelper comRuntimeHelper = null;
	private int portForRemUnknown = -1;
	private int protectionLevel = 2;
	private Thread remUnknownThread = null;
	
	JIComOxidDetails(JILocalCoClass javaInstance, JIOxid oxid, JIObjectId oid
					,String iid,String ipid,JIInterfacePointer ptr, JIComOxidRuntimeHelper helper,int protectionLevel)
	{
		referent = javaInstance;
		this.ipid = ipid;
		this.oxid = oxid;
		this.oid = oid;
		this.iid = iid;
		this.ptr = ptr;
		this.protectionLevel = protectionLevel;
		comRuntimeHelper = helper;
	}

	void setPortForRemUnknown(int port)
	{
		portForRemUnknown = port;
	}
	
	int getPortForRemUnknown()
	{
		return portForRemUnknown;
	}
	
	String getIID()
	{
		return iid;
	}

	String getIpid() 
	{
		return ipid;
	}

	JIObjectId getOid() 
	{
		return oid;
	}

	JIOxid getOxid() 
	{
		return oxid;
	}

	JILocalCoClass getReferent()
	{
		return referent;
	}
	
	JIInterfacePointer getInterfacePtr()
	{
		return ptr;
	}
	
	JIComOxidRuntimeHelper getCOMRuntimeHelper()
	{
		return comRuntimeHelper;
	}
	
	int getProtectionLevel()
	{
		return protectionLevel;
	}
	
	void setRemUnknownThread(Thread remUnknown)
	{
	    this.remUnknownThread = remUnknown;
	}
	
	void interruptRemUnknownThread()
	{
		if (remUnknownThread != null)
		{
			remUnknownThread.interrupt();
		}
	}
}
