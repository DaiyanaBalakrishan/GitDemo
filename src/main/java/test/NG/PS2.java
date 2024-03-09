package test.NG;

public class PS2 extends PS3{
	int a;
	
	
public PS2(int a) {
	super(a);
		this.a=a;
	}

public int increment() {
	a=a+1;
	return a;
}
public int drecrement() {
	a=a-1;
	return a;
}
}
