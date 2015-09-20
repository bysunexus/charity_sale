/**
 * via:com.appspot.trent.denis
 * https://code.google.com/p/denis-dns/
 */
package dns.hijacking;

import java.util.ArrayList;

public class HostRecord{
	public HostRecord(String _domainName) {
		domainName = _domainName;
	}
	
	public void addIpAddress(IPAddress address) {
		for (IPAddress a: ipAddresses) {
			if (a.equals(address))
				return;
		}
		ipAddresses.add(address);
	}
	
	public String getDomainName() {
		return domainName;
	}

	public ArrayList<IPAddress> getIpAddresses() {
		return ipAddresses;
	}
	
	public String toString() {
		return ipAddresses.toString();
	}

	String domainName = null;
	ArrayList<IPAddress> ipAddresses = new ArrayList<>();
}
