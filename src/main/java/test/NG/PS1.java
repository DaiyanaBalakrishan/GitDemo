package test.NG;

import org.testng.annotations.Test;

public class PS1 extends PS{
	
@Test
public void testRun() {
	doThis();
	int a=3;
	PS2 ps2=new PS2(3);
	System.out.println(ps2.increment());
	System.out.println(ps2.drecrement());
	System.out.println(ps2.multiplyTwo());
	System.out.println(ps2.multiplyThree());
}
}
