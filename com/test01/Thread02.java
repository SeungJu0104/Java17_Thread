package com.test01;

public class Thread02 {
	/* [스레드 스케줄링]
	 * 1. 우선순위 (priority)
	 * setPriority 메소드 사용한다.
	 * 스레드에 1 - 10까지 우선 순위를 부여할 수 있다.(10이 가장 높다)
	 * 우선 순위 기본 값은 5
	 * 
	 * 2. 순환할당 (Round Robin)
	 * JVM이 결정하기 때문에 코드로 순서 수정 불가하다.
	 * 
	 */

	public static void main(String[] args) {
		
		MyThread3 m1 = new MyThread3("야옹");
		MyThread3 m2 = new MyThread3("멍멍");
		//MyThread3 m3 = new MyThread3("야옹");
		
		m1.start();
		m2.start();
		//두 개의 별도 스레드가 번갈아 가면서 실행된다.
		//언제 번갈아가며 실행될지는 매번 실행할 때마다 다르다.
		
		//우선순위 스케줄링
		m1.setPriority(10);
		m2.setPriority(2);
		//반드시 m1의 스레드가 m2의 스레드보다 먼저 종료된다.

	}

}

class MyThread3 extends Thread{
	
	//매개변수 생성자
	public MyThread3(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 250; i++) {
			System.out.println(this.getName() + " = " + i);
		}
		System.out.println(this.getName() + " 종료!");
	}
}
