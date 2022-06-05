package bean;

public class A {
	B b;

	public A() {
		b = new B();
		//내부에서 new로 메서드를 선언했기 때문에 의존성을 주입받음.
		
	}
	
}
