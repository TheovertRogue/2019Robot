package org.usfirst.frc.team3786.robot.vision;

import org.usfirst.frc.team3786.robot.utils.pixy2.links.SPILink;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;

public class Cameras {

    private static UsbCamera drive = null;
    private static PixyCamera pixy = null;

    public static void setup() {
        initDrive();
        pixy = new PixyCamera(new SPILink());
    }

    public static void run() {
        pixy.run();
    }

    public static void initDrive() {
        drive = CameraServer.getInstance().startAutomaticCapture();
        if (drive != null) {
			drive.setVideoMode(PixelFormat.kBGR, 320, 240, 30);
			drive.setResolution(320, 240);
            drive.setFPS(30);
            drive.setWhiteBalanceManual(5000);
			drive.setBrightness(50);
            drive.setExposureManual(50);
		}
    }

}