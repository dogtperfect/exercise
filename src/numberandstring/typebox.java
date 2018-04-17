package numberandstring;

public class typebox {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		Integer it = new Integer(i);
		int i2 = it.intValue();
		int i3 = it;
		System.out.println(it instanceof Number);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		byte b = 23;
		Byte bt = new Byte(b);
		byte b1 = bt.byteValue();
		byte b2 = bt;
		System.out.println(bt instanceof Number);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		char c = 'c';
//		char c = "c";
		char c1 = 'Ô´';
//		char c3 = 'Ô­ÐÍ';
//		float f = 52.11;
		float f = 52.11f;
		double d = 52.11; 
		boolean bl1 = true;
		boolean bl2 = false;
//		boolean bl3 = 1;
		String str = "hello java";
		String str1 = "hello java";
		Long lo = 23L;
//		Long lo1 = 23;
		int hexVal = 0x23;
		int oxVal = 023;
		int binVal = 0b11111;
		System.out.println(hexVal);
		System.out.println(oxVal);
		System.out.println(binVal);
		double bb = 123.45;
		double bb2 = 1.2345e2;
		System.out.println(bb);
		System.out.println(bb2);
		char ccc = 'c';
		short sss = 66;
		c = (char) sss;
		short s23 = 1;
		short s24 = 2;
		System.out.println((s23+s24) instanceof int);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
