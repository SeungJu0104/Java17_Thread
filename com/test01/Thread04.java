package com.test01;

public class Thread04 {

	public static void main(String[] args) {
		for(int i = 0; i < 50; i++) {
			try {
				Thread.sleep(1000);
				//스레드 일시정지 메소드
				//sleep 메소드
				//()안에는 일시정지 시킬 시간을 적는다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.print("A ");
		}
		//메인 스레드를 1000ms 동안 일시정지시킨 다음 대기 상태로 돌아간다.
		//그리고 여기서는 실행할 다른 스레드가 없으므로 메인 스레드가 대기 상테에서 다시 실행에 들어가 A를 출력한다.
		//이 과정을 계속 반복한다.(반복문을 사용했다.)
		

	}

}
