package genericDeser.util;

public class Second {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(DoubleValue2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (LongValue ^ (LongValue >>> 32));
		result = prime * result + (int) (LongValue2 ^ (LongValue2 >>> 32));
		result = prime * result + ShortValue;
		result = prime * result + ShortValue2;
		result = prime * result + ((StringValue == null) ? 0 : StringValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Second other = (Second) obj;
		if (Double.doubleToLongBits(DoubleValue) != Double.doubleToLongBits(other.DoubleValue))
			return false;
		if (Double.doubleToLongBits(DoubleValue2) != Double.doubleToLongBits(other.DoubleValue2))
			return false;
		if (LongValue != other.LongValue)
			return false;
		if (LongValue2 != other.LongValue2)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (ShortValue2 != other.ShortValue2)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}
	private short ShortValue;
	private short ShortValue2;
	private long LongValue;
	private long LongValue2;
	private double DoubleValue;
	private double DoubleValue2;
	private String StringValue;
	
	public void Second()
	{
		Logger.writeMessage("In second constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public void setShortValue(short ish)
	{
		ShortValue = ish;
	}
	public void setShortValue2(short ish2)
	{
		ShortValue2 = ish2;
	}
	public void setLongValue(long iln)
	{
		LongValue = iln;
	}
	public void setLongValue2(long iln2)
	{
		LongValue2 = iln2;
	}
	public void setDoubleValue(double idbl)
	{
		DoubleValue = idbl;
	}
	public void setDoubleValue2(double idbl2)
	{
		DoubleValue2 = idbl2;
	}
	public void setStringValue(String istr)
	{
		StringValue = istr;
	}
	
	
	public short getShortValue()
	{
		return ShortValue;
	}
	public short getShortValue2()
	{
		return ShortValue2;
	}
	public long getLongValue()
	{
		return LongValue;
	}
	public long getLongValue2()
	{
		return LongValue2;
	}
	public double getDoubleValue()
	{
		return DoubleValue;
	}
	public double getDoubleValue2()
	{
		return DoubleValue2;
	}
	public String getStringValue()
	{
		return StringValue;
	}

}
