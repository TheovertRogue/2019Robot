package org.usfirst.frc.team3786.robot.subsystems.vision;

import java.util.ArrayList;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3786.robot.Dashboard;

import org.usfirst.frc.team3786.robot.subsystems.vision.Cameras;

import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

public class TargetBall extends Command {

    private static ArrayList<Block> blocks = Cameras.getPixyCamera1().getPixy().getCCC().getBlocks();

    private static final int blockSignature = 1;

    public TargetBall() {
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Cameras.getPixyCamera1().getPixy().getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 25);
        Block largestBlock = null;

        for (Block block : blocks) {
            if (block.getSignature() == blockSignature) {
                if (largestBlock == null) {
                    largestBlock = block;
                } else if (block.getWidth() > largestBlock.getWidth()) {
                    largestBlock = block;
                }
            }
        }
        Dashboard.getInstance().putNumber(false, "Ball X", largestBlock.getX());
        Dashboard.getInstance().putNumber(false, "Ball Y", largestBlock.getY());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

}