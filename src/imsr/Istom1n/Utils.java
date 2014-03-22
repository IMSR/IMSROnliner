package imsr.Istom1n;

public class Utils {
	
	public int longToInt(long lg) {
		return (int) (lg/6000);
	}
	
	public long intToLong(int i) {
		return (long) (i*6000);
	}
}
