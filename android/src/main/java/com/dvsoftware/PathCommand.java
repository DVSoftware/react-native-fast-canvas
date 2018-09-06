package com.dvsoftware;

public class PathCommand {
    public int commandType;
    public double[] params;

    public PathCommand(int commandType, double[] params) {
        this.commandType = commandType;
        this.params = params;
    }
}