package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.Objects;

public class Flow {
	private LocalDate day;
	private double flow;
	private River river;

	public Flow(LocalDate day, double flow, River river) {
		this.day = day;
		this.flow = flow;
		this.river = river;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

	@Override
	public String toString() {
		return "Flow [day=" + day + ", flow=" + flow + ", river=" + river + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, flow, river);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flow other = (Flow) obj;
		return Objects.equals(day, other.day) && Double.doubleToLongBits(flow) == Double.doubleToLongBits(other.flow)
				&& Objects.equals(river, other.river);
	}

	
}
