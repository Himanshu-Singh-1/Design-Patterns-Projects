package genericDeser.util;

public class First {
	private byte ByteValue;
	private short ShortValue;
	private int IntValue;
	private long LongValue;
	private float FloatValue;
	private double DoubleValue;
	private boolean BooleanValue;
	private char CharValue;
	private String StringValue;

	public First()
	{
		Logger.writeMessage("In first constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public void setByteValue(byte iBy)
	{
		ByteValue = iBy;
	}
	public void setShortValue(short iSh)
	{
		ShortValue = iSh;
	}
	public void setIntValue(int iIn)
	{
		IntValue = iIn;
	}
	public void setLongValue(long iln)
	{
		LongValue = iln;
	}
	public void setFloatValue(float ifl)
	{
		FloatValue = ifl;
	}
	public void setDoubleValue(double ido)
	{
		DoubleValue = ido;
	}
	public void setBooleanValue(boolean ibo)
	{
		BooleanValue = ibo;
	}
	public void setCharValue(char ich)
	{
		CharValue = ich;
	}
	public void setStringValue(String istr)
	{
		StringValue = istr;
	}
	
	
	public byte getByteValue()
	{
		return ByteValue;
	}
	public short getShortValue()
	{
		return ShortValue;
	}
	public Integer getIntValue()
	{
		return IntValue;
	}
	public Long getLongValue()
	{
		return LongValue;
	}
	public float getFloatValue()
	{
		return FloatValue;
	}
	public Double getDoubleValue()
	{
		return DoubleValue;
	}
	public Boolean getBooleanValue()
	{
		return BooleanValue;
	}
	public Character getCharValue()
	{
		return CharValue;
	}
	public String getStringValue()
	{
		return StringValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (BooleanValue ? 1231 : 1237);
		result = prime * result + ByteValue;
		result = prime * result + CharValue;
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(FloatValue);
		result = prime * result + IntValue;
		result = prime * result + (int) (LongValue ^ (LongValue >>> 32));
		result = prime * result + ShortValue;
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
		First other = (First) obj;
		if (BooleanValue != other.BooleanValue)
			return false;
		if (ByteValue != other.ByteValue)
			return false;
		if (CharValue != other.CharValue)
			return false;
		if (Double.doubleToLongBits(DoubleValue) != Double.doubleToLongBits(other.DoubleValue))
			return false;
		if (Float.floatToIntBits(FloatValue) != Float.floatToIntBits(other.FloatValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		if (LongValue != other.LongValue)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}
	
}
