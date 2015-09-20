/**
 * via:com.appspot.trent.denis
 * https://code.google.com/p/denis-dns/
 */
package dns.hijacking;

import java.util.Arrays;

public class IPAddress {
	public IPAddress(byte nums[]) throws Exception {
		// copy
		if (nums.length == 4)
			buffer = nums;
		else
			throw new Exception("Address " + Arrays.toString(nums) + " is not OK");
	}
	
	public String toString() {
		return String.valueOf((int) buffer[0] & 0xFF) + '.' + ((int) buffer[1] & 0xFF) + '.' + ((int) buffer[2] & 0xFF) + '.' + ((int) buffer[3] & 0xFF);
	}
	
	public boolean equals(IPAddress other) {
		return (buffer.length == 4) &&
			(other.buffer.length == 4) &&
			(buffer[0] == other.buffer[0]) &&
			(buffer[1] == other.buffer[1]) &&
			(buffer[2] == other.buffer[2]) &&
			(buffer[3] == other.buffer[3]);
	}
	
	public byte[] getBuffer() {
		return buffer;
	}
	
	byte buffer[];
}
