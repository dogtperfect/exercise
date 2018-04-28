package me.xunmi.exception;

public class TestSelfException {
	public String name;
	protected int hp;
	
	public void attackHero(TestSelfException h) throws SelfException{
		if(h.hp == 0) {
			throw new SelfException("i am self exception");
		}
	}
	
	public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSelfException tse1 = new TestSelfException();
		tse1.name =  "tse1";
		tse1.hp = 100;
		
		TestSelfException tse2 = new TestSelfException();
		tse2.name = "tse2";
		tse2.hp = 0;
		try {
			tse1.attackHero(tse2);
		} catch(SelfException se) {
// e.getMessage(), 取得 自定义 exception 构造函数传入的 String
			System.out.println("the reason of exception is: "+se.getMessage());
			se.printStackTrace();
		}
	}

}
