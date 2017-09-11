Appium project for ios 

Steps for Appium set up on MAC:

Steps:

1. Install Java, Xcode(https://developer.apple.com/xcode/download/ ).
2. Go to terminal and install commandline tools: xcode-select --install.
3. Verify command line tools installation: xcode-select –p. You should see: /Applications/Xcode.app/Contents/Developer.  
4. Install Home brew package management tool: /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)”
5. Install node: brew install node(http://blog.teamtreehouse.com/install-node-js-npm-mac)
6. Check node and nom installation: node -v , npm -v
7. Install Appium(server): npm install -g appium@1.6.5. Check Appium version: Appium –v
8. Install Appium client: npm install wd  
9. Install Xcuitest Driver: npm install appiun-xcuitest-driver
10. Install AppiumDoctor: npm install appiun-doctor –g
11. To check iOS configuration: Appium-doctor --ios
12. Type “Appium” to start the Appium server.
13. To check list of available simulators: Instruments -s devices, xcrun simctl list

Appium Inspector: 

No official Appium Inspector is released for Appium 1.6 or above. So there are few workarounds to identify iOS native elements.(https://medium.com/@chenchaoyi/the-options-of-inspecting-ios-10-app-with-appium-1-6-534ba166b958)

a.Open GUI of Appium (Older version, ex:1.5.3)and set all required capabilities.
b.Start Appium 1.6.5(1.6 or above) from command prompt.
c.Once server is started, start inspecting elements by click on Appium Inspector on GUI


Install External Dependencies:

Ideviceinstaller:

Ideviceinstaller is a tool to interact with the installation_proxy of an iOS device allowing installing, upgrading, uninstalling, archiving, restoring and enumerating installed or archived apps.
In order to install this tool, Open the terminal and run the following command:

Command: brew install --HEAD  ideviceinstaller

Carthage:

Carthage builds your dependencies and provides you with binary frameworks, but you retain full control over your project structure and setup. Carthage does not automatically modify your project files or your build settings.

Command: brew install carthage

Note: if you previously installed the binary version of Carthage, you should delete    “/Library/Frameworks/CarthageKit.framework”

Ios-deploy:

Install and debug iOS apps without using Xcode. Designed to work on un-jailbroken devices.
Ideviceinstaller  doesn't work with iOS 10 yet. So we need to install ios-deploy

Command: npm install –g ios-deploy

DeviceConsole:

Command: npm install –g deviceconsole

Xcpretty:

Xcpretty is a fast and flexible formatter for xcodebuild.
It does one thing, and it should do it well.

Command: gem install xcpretty

Libimobiledevice:

Command: brew install libimobiledevice –HEAD  #install from head to get important update
