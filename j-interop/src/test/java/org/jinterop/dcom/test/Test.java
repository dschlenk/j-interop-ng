package org.jinterop.dcom.test;

import org.jinterop.dcom.core.JIComServer;

public class Test {

    public static void main(String[] args) {
//	 try {
        boolean b = !(null instanceof JIComServer);
        // Socket socket = new Socket("***REMOVED***",139);
        //socket.close();
//	 UniAddress mydomaincontoller = UniAddress.getByName( "192.168.170.6" );
//	 NtlmPasswordAuthentication mycreds = new NtlmPasswordAuthentication( "***REMOVED***", "***REMOVED***", "***REMOVED***" );
//
//	 SmbSession.logon( mydomaincontoller, mycreds );
        //	 Config.setProperty("jcifs.smb.client.laddr","***REMOVED***");
        //	 Config.setProperty("jcifs.smb.client.domain","***REMOVED***");
//		 System.setProperty("jcifs.smb.client.laddr","***REMOVED***");
//		 System.setProperty("jcifs.smb.client.domain","***REMOVED***");
//		 System.setProperty("jcifs.netbios.hostname","***REMOVED***");

        //NtlmChallenge challenge = SmbSession.getChallengeForDomain();
//		 UniAddress mydomaincontoller = UniAddress.getByName("***REMOVED***");
//		 NtlmPasswordAuthentication mycreds = new NtlmPasswordAuthentication( "***REMOVED***", "***REMOVED***", "***REMOVED***" );
//		 SmbSession.logon(mydomaincontoller,mycreds);
        //PLEASE NOTE THAT THE WINDOWS "SERVER" SERVICE SOULD BE RUNNING !!! OTHERWISE THE
        //GETCHALLENGE WILL FAIL.
//		 UniAddress mydomaincontoller = UniAddress.getByName("***REMOVED***");
//		 byte[] b =  SmbSession.getChallenge(mydomaincontoller,139);
        int i = 0;
        // NtlmChallenge challenge = SmbSession.getChallengeForDomain();

        // SUCCESS
//	 } catch( SmbAuthException sae ) {
//	     // AUTHENTICATION FAILURE
//	     sae.printStackTrace();
//	 } catch( SmbException se ) {
//	     // NETWORK PROBLEMS?
//	     se.printStackTrace();
//	 } catch (UnknownHostException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
    }

    public void test() {
        System.out.println("Called back !!!");
    }

}
