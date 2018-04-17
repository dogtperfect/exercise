package numberandstring;

public class typebox {
	
	public static char[] genRan() {
		char[] gr= new char[5];
		short start = '0';
		short end ='z'+1;
		for (int i=0; i<5 ;i++) {
			while(true) {
				char c = (char) (Math.random()*(end - start) + start);
				if (Character.isLetter(c) || Character.isDigit(c)) {
					gr[i] = c;
					break;
				}	
			}
		}
		return gr;
	}
	
	public static char[] genRan2() {
		char[] gr = new char[5];
		String pool = "";
		for (short i='0'; i<='9'; i++) {
			pool+=(char)i;
		}
		for (short i='a'; i<='z'; i++) {
			pool+=(char)i;
		}
		for (short i='A'; i<='Z'; i++) {
			pool+=(char)i;
		}
		for (int i=0; i<gr.length; i++) {
			int w = (int) (Math.random()*(pool.length()));
			gr[i] = pool.charAt(w);
		}
		return gr;
	}
	
	
	public static void pojie() {
		char[] passwd = genRan();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int i = 5;
//		Integer it = new Integer(i);
//		int i2 = it.intValue();
//		int i3 = it;
//		System.out.println(it instanceof Number);
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
//		byte b = 23;
//		Byte bt = new Byte(b);
//		byte b1 = bt.byteValue();
//		byte b2 = bt;
//		System.out.println(bt instanceof Number);
//		System.out.println(Byte.MAX_VALUE);
//		System.out.println(Byte.MIN_VALUE);
//		char c = 'c';
//		char c = "c";
//		char c1 = '源';
//		char c3 = '原型';
//		float f = 52.11;
//		float f = 52.11f;
//		double d = 52.11; 
//		boolean bl1 = true;
//		boolean bl2 = false;
//		boolean bl3 = 1;
//		String str = "hello java";
//		String str1 = "hello java";
//		Long lo = 23L;
//		Long lo1 = 23;
//		int hexVal = 0x23;
//		int oxVal = 023;
//		int binVal = 0b11111;
//		System.out.println(hexVal);
//		System.out.println(oxVal);
//		System.out.println(binVal);
//		double bb = 123.45;
//		double bb2 = 1.2345e2;
//		System.out.println(bb);
//		System.out.println(bb2);
//		char ccc = 'c';
//		short sss = 66;
//		c = (char) sss;
//		System.out.println("66对应的字母是: "+c);
//		short s23 = 1;
//		short s24 = 2;
//		short s25 = s23 + s24;
		
//		String sp = "开心果";
//		String wp = new String("松子");
//		char[] list = new char[] { '蛋','手','机'};
//		String list2 = new String(list);
//		String list3 = sp+wp;
//		list3 = "改变"; //String 不可改变, 但是可以整体替换
//		String jzFormat = "%s 和 %s 和 %s";
//		String jg = String.format(jzFormat, sp,wp,list2);
//		System.out.println(jg);
//		System.out.println(jg.length());
		
		System.out.println(genRan());
		System.out.println(genRan2());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
