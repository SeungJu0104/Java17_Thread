package com.test01;

public class Thread03 {
	
	public static void main(String[] args) {
		//여기서는 별도로 메인 스레드 동작을 코딩하지 않았기때문에
		//메인 스레드 동작하자마자 종료된다.
		
		MyThread3 m1 = new MyThread3("야옹");
		MyThread3 m2 = new MyThread3("멍멍");
		
		long start_time = System.currentTimeMillis();//m1 스레드 동작 시간 파악 용도
		m1.start();
		
		try {
			m1.join();
			//join은 스레드를 일시정지 시키는 메소드
			//m1 스레드가 종료될 때까지 다른 스레드를 멈춘다.
			//()안에 시간을 넣으면 해당 시간만큼 다른 스레드를 멈춘다.
			//()안에 별도로 시간을 지정하지 않으면 해당 스레드가 종료될 때까지 다른 스레드를 멈춘다.
			//(해당 시간만큼 m1 스레드만 동작한다.)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end_time = System.currentTimeMillis();//m1 스레드 동작 시간 파악 용도
		
		m2.start();
		//m1 스레드가 join 메소드를 이용해 다른 스레드를 일시정지 시켰기때문에
		//m1 스레드가 종료될 때까지 m2는 실행되지 않는다.
		System.out.println("m1 스레드 실행시간 : " + (end_time - start_time));
	}

}
