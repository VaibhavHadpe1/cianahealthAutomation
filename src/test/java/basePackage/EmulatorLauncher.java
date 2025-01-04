package basePackage;

import java.io.File;
import java.io.IOException;

public class EmulatorLauncher {

    public static void main(String[] args) {
        startEmulator();
    }
    public static void startEmulator()
    {
        // Full path to the emulator binary
        String emulatorPath = "C:\\Users\\Archents\\AppData\\Local\\Android\\Sdk\\emulator\\emulator";

        // The AVD name you want to launch
        String avdName = "Pixel_7_API_33";

        // Construct the command to launch the emulator
        String[] emulatorCommand = { emulatorPath, "-avd", avdName };

        ProcessBuilder processBuilder = new ProcessBuilder(emulatorCommand);
        try
        {
            // Start the process
            Thread.sleep(5000);
            Process process = processBuilder.start();
            System.out.println("Emulator started");
            Thread.sleep(15000);
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



//    public static void startEmulator() {
//        String sdkPath = "C:\\Users\\Archents\\AppData\\Local\\Android\\Sdk";
////                "C:\\Users\\Sandeep\\AppData\\Local\\Android\\Sdk\\";
//        String emulatorPath = sdkPath + "\\emulator" + File.separator + "emulator";
////        System.out.println("Starting emulator for '" + "realme Pad X" + "' ...");
////        String[] aCommand = new String[]{emulatorPath, "-avd", nameOfAVD};
//        try {
//            ProcessBuilder process = new ProcessBuilder("cmd.exe", "/C", "start", emulatorPath, "-avd", "Pixel_7_API_33");
//
//            process.start();
//            Thread.sleep(10000);
//            System.out.println("Emulator launched successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
