package com.digitalpath.installermon;
import java.io.ByteArrayOutputStream;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class SSHTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(executeRemoteCommand("root", "p0keR$", "10.0.201.10", 22));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(0);

	}
	
	public static String executeRemoteCommand(String username, String password,
			String hostname, int port) throws Exception {
		System.out.println("executeremotecommand");

		JSch jsch = new JSch();
		Session session = jsch.getSession(username, hostname, 22);
		session.setPassword(password);

		// Avoid asking for key confirmation
		Properties prop = new Properties();
		prop.put("StrictHostKeyChecking", "no");
		session.setConfig(prop);

		session.connect();

		// SSH Channel
		ChannelExec channelssh = (ChannelExec) session.openChannel("exec");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		channelssh.setOutputStream(baos);

		
		// Execute command
		channelssh.setCommand("iwpriv ath0 site_survey 1; sleep 1; iwlist ath0 scanning; sleep 1; iwlist ath0 scanning; sleep 3; iwlist ath0 scanning");
		channelssh.connect();
		Thread.sleep(5000);
		channelssh.disconnect();
		System.out.println("END");

		return baos.toString();
	}

}
