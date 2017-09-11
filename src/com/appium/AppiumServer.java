package com.appium;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

public class AppiumServer {

	public void startServer() {
		
	CommandLine command = new CommandLine(
			"/Applications/Appium.app/Contents/Resources/node/bin/node");
	command.addArgument(
			"/usr/local/lib/node_modules/appium/build/lib/appium.js",
			false);
	command.addArgument("--address", false);
	command.addArgument("127.0.0.1");
	command.addArgument("--port", false);
	command.addArgument("4723");
	command.addArgument("--full-reset", false);
	DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
	DefaultExecutor executor = new DefaultExecutor();
	executor.setExitValue(1);
	try {
		executor.execute(command, resultHandler);
		Thread.sleep(5000);
		System.out.println("Appium server started.");
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

public void stopServer() {
	String[] command = { "/usr/bin/killall", "-KILL", "node" };
	try {
		Runtime.getRuntime().exec(command);
		System.out.println("Appium server stopped.");
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
