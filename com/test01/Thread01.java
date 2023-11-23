package com.test01;

public class Thread01 {
	/* [스레드 생성]
	 * 1. Thread 클래스 상속
	 * Thread 클래스를 상속받은 클래스명 레퍼런스 변수 = new Thread 클래스를 상속받은 클래스명 (매개변수 생성자 있으면 변수 쓰고 아님 말고);
	 * Thread 클래스를 상속받았을 때는 일반적인 객체 생성 방법과 동일하다.
	 * 
	 * 2. Runnable 인터페이스 상속
	 * Thread 레퍼런스 변수 = new Thread(new Runnable 인터페이스를 상속받은 클래스명());
	 * Runnable을 구현한 객체 생성
	 * 
	 * 별도의 스레드는 반드시 start 메소드를 이용해 실행한다.
	 * 그리고 실행 내용은 run 메소드를 오버라이딩 한다.
	 */

	public static void main(String[] args) {
		//메인메소드는 위에서 아래로 순차적으로 실행된다.
		System.out.println("---main start---");
		
//		MyThread mt = new MyThread();
//		mt.run();
		//이렇게 실행할 경우 메인 스레드 stack에 담겨 run을 실행하고 다시 main이 동작한다.
		//stack은 FILO 형태의 자료구조
		//즉, 메인 스레드와 별개의 스레드에서 병렬로 실행하는 것이 아니라 메인 스레드에서 순차적으로 실행되는 것이다.
		//스레드로 실행하는 것이 아닌 run 메소드를 단순 실행.
		
		//Thread 레퍼런스 변수 = new Thread(new Runnable 인터페이스를 상속받은 클래스명());
		//Runnable을 구현한 객체 생성
		Thread m1 = new Thread(new MyThread());
		m1.start();
		//레퍼런스 변수.start() 는 별개의 스레드를 실행하는 메소드
		//이렇게 스레드 객체를 생성하고 실행하면
		//메인 스레드와 별개의 스레드에서 병렬로 실행한다.
		//실행해보면 메인 스레드를 실행한 후, MyThread 클래스의 별개의 스레드를 실행한다.
		
		Thread m2 = new Thread(new MyThread());
		m2.start();
		//이렇게 실생하면 main 스레드가 실행된 후
		//두 별개의 스레드가 번갈아가며 실행된다.
		//다만 언제 번갈아 실행될지는 매번 다르다.
		
		System.out.println("---main stop---");
		//코드가 여기 있어도 메인 스레드에서 수행되는 코드이기 때문에
		//다른 별개의 스레드들 보다 먼저 수행된다.
		
	}

}

//하나의 자바 파일 내에 클래스는 여러개 생성할 수 있지만
//접근제한자가 붙은 클래스는 반드시 하나만 만들 수 있다.
class MyThread implements Runnable {

	@Override
	public void run() {
		//메인 스레드와 별개의 스레드에서 실행할 코드 작성
		for(int i = 0; i < 300; i++) {
			System.out.println("i = " + i);
		}
	}
	
}

class MyThread2 implements Runnable {
	
	@Override
	public void run() {
		for(int i = 0; i > -300; i--) {
			System.out.println("i = " + i);
		}
	}
}
