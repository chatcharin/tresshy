package org.rmutl.tresshy;

import java.awt.geom.Point2D;

import wiiremotej.IRLight;
public class IRDot extends Point2D.Double {

	private final int id;
	private double size;
	
	public IRDot(int id, double x, double y, double size) {
		super(x, y);
		this.id = id;
		this.size = size;
	}
	
	public IRDot(IRDot dot) {
		this(dot.getId(), dot.getX(), dot.getY(), dot.getSize());
	}

	public IRDot(int id, IRLight light) {
		this(id, light.getX(), light.getY(), light.getSize());
	}

	@Override
	public String toString() {
		return String.format("[Dot%d: x = %.2f, y = %.2f, s = %.2f]", id, x, y, size);
	}
	
	public double getSize() {
		return size;
	}
	
	public int getId() {
		return id;
	}
}
