package descent.slicer;

import descent.tman.IDescriptor;

/**
 * Descriptor describing the state of a peer and its position in the slicing
 * overlay network.
 */
public class RankDescriptor implements IDescriptor, Comparable<RankDescriptor> {

	public Integer rank;
	public Double frequency;
	public boolean set;

	public RankDescriptor() {
		this.rank = Integer.MAX_VALUE;
		this.frequency = 0.;
		this.set = false;
	}

	public double ranking(IDescriptor other) {
		RankDescriptor o = (RankDescriptor) other;

		if (o.rank > this.rank + 1 || o.rank.equals(Integer.MAX_VALUE) || this.rank.equals(Integer.MAX_VALUE)) {
			return Integer.MAX_VALUE;
		} else {
			return this.distanceRank(o);
		}
	}

	public double distanceRank(RankDescriptor o) {
		return Math.abs(o.rank + 1 - (this.rank));
	}

	public double distanceFrequency(RankDescriptor o) {
		return Math.abs(o.frequency - this.frequency);
	}

	public void setRank(Integer rank) {
		this.rank = rank;
		this.set = true;
	}

	public void setFrequency(Double frequency) {
		this.frequency = frequency;
	}

	public int compareTo(RankDescriptor o) {
		if (this.frequency > o.frequency) {
			return 1;
		} else if (this.frequency < o.frequency) {
			return -1;
		} else {
			return 0;
		}
	}

	public boolean isSet() {
		return this.set;
	}
}