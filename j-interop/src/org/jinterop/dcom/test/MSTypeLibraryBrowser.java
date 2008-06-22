package org.jinterop.dcom.test;

import java.net.UnknownHostException;

import org.jinterop.dcom.common.JIException;
import org.jinterop.dcom.core.IJIComObject;
import org.jinterop.dcom.core.JIComServer;
import org.jinterop.dcom.core.JIProgId;
import org.jinterop.dcom.core.JISession;
import org.jinterop.dcom.core.JIString;
import org.jinterop.dcom.impls.FuncDesc;
import org.jinterop.dcom.impls.IJIDispatch;
import org.jinterop.dcom.impls.IJITypeInfo;
import org.jinterop.dcom.impls.IJITypeLib;
import org.jinterop.dcom.impls.JIComFactory;
import org.jinterop.dcom.impls.TypeAttr;
import org.jinterop.dcom.impls.VarDesc;

public class MSTypeLibraryBrowser {

	private JIComServer comServer = null;
	private IJIDispatch dispatch = null;
	private IJIComObject unknown = null;

	public MSTypeLibraryBrowser(String address, String args[]) throws JIException, UnknownHostException
	{
		JISession session = JISession.createSession(args[1],args[2],args[3]);
		comServer = new JIComServer(JIProgId.valueOf(session,"InternetExplorer.Application"),address,session);
	}

	public void start() throws JIException
	{
		unknown = comServer.createInstance();
		dispatch = (IJIDispatch)JIComFactory.instantiateComObject(JIComFactory.IID_IDispatch,unknown);
		IJITypeInfo typeInfo = dispatch.getTypeInfo(0);
		IJITypeLib typeLib = (IJITypeLib)((Object[])typeInfo.getContainingTypeLib())[0];
		Object[] result = typeLib.getDocumentation(-1);
		System.out.println(((JIString)result[0]).getString());
		System.out.println(((JIString)result[1]).getString());
		System.out.println(((JIString)result[3]).getString());
		System.out.println("-------------------------------");
		int typeInfoCount = typeLib.getTypeInfoCount();
		int i = 0;
		String g_arrClassification[] = { "Enum","Struct","Module","Interface",
			"Dispinterface","Coclass","Typedef","Union"};
		for(; i < typeInfoCount;i++)
		{
			result = typeLib.getDocumentation(i);
			int j = typeLib.getTypeInfoType(i);


			System.out.println(((JIString)result[0]).getString());
			System.out.println(((JIString)result[1]).getString());
			System.out.println(((JIString)result[3]).getString());
			System.out.println(g_arrClassification[j]);

			IJITypeInfo typeInfo2 = typeLib.getTypeInfo(i);
			TypeAttr typeAttr =  typeInfo2.getTypeAttr();
			for(j = 0;j < typeAttr.cFuncs;j++)
			{
				FuncDesc funcDesc = typeInfo2.getFuncDesc(j);
				result = typeInfo2.getDocumentation(funcDesc.memberId);
				System.out.println(((JIString)result[0]).getString());
				System.out.println(((JIString)result[1]).getString());
				System.out.println(((JIString)result[3]).getString());
			}

			for(j = 0;j < typeAttr.cVars;j++)
			{
				if(j == 77)
				{
					int kk = 0;
				}
				VarDesc varDesc = typeInfo2.getVarDesc(j);
				result = typeInfo2.getDocumentation(varDesc.memberId);
				System.out.println(((JIString)result[0]).getString());
				System.out.println(((JIString)result[1]).getString());
				System.out.println(((JIString)result[3]).getString());
				//System.out.println(j);
			}


			System.out.println("***************************************");
		}
		JISession.destroySession(dispatch.getAssociatedSession());
	}

	public static void main(String[] args) {
		try {
			if (args.length < 4)
		    {
		    	System.out.println("Please provide address domain username password");
		    	return;
		    }
			MSTypeLibraryBrowser typeLibraryBrowser = new MSTypeLibraryBrowser(args[0],args);
			typeLibraryBrowser.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
