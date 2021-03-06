// 알고리즘_과제2_한상민

import java.util.Scanner;

class BinSearchTree {
	
	static Scanner stdIn = new Scanner(System.in);

	// 데이터 (회원번호 + 이름)
	static class Data {
		public static final int NO   = 1;	// 번호를 읽어 들일까요?
		public static final int NAME = 2;	// 이름을 읽어 들일까요?

		private Integer no;					// 회원번호 (키 값)
		private String  name;				// 이름

		// 키 값
		Integer keyCode() {
			return no;
		}

		// 문자열을 반환합니다.
		public String toString() {
			return name;
		}

		// 데이터를 입력합니다.
		void scanData(String guide, int sw) {
			System.out.println(guide);

			if ((sw & NO) == NO) {
				System.out.print("상품 번호 입력 : ");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("상품명 입력 : ");
				name = stdIn.next();
			}
		}
	}

	// 메뉴 열거형
	enum Menu {
		ADD(      "상품 등록"),
		REMOVE(   "상품 삭제"),
		SEARCH(   "상품 검색"),
		PRINT(    "전체 상품 조회"),
		TERMINATE("종료");

		private final String message;			// 출력할 문자열 

		static Menu MenuAt(int idx) {			// 서수가 idx인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) {					// 생성자
			message = string;
		}

		String getMessage() {					// 출력할 문자열을 반환
			return message;
		}
	}

	// 메뉴 선택
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print("：");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;								// 메뉴
		Data data;								// 추가용 데이터 참조
		Data ptr;								// 검색용 데이터 참조
		Data temp = new Data();					// 입력용 데이터
		BinTree<Integer, Data> tree = new BinTree<Integer, Data>();

		do {
			switch (menu = SelectMenu()) {
			case ADD :
				data = new Data();
			 	data.scanData("상품 등록", Data.NO | Data.NAME);
			 	tree.add(data.keyCode(), data);
			 	break;

			case REMOVE :						// 노드를 삭제
				temp.scanData("상품 삭제", Data.NO);
			 	tree.remove(temp.keyCode());
			 	System.out.println("상품 삭제 완료");
			 	break;

			case SEARCH :						// 노드를 검색
				temp.scanData("상품 검색", Data.NO);
			 	ptr = tree.search(temp.keyCode());
			 	if (ptr != null)
					System.out.println("상품명 : " + ptr);
				else
			 		System.out.println("해당 데이터가 없습니다.");
			 	break;

			case PRINT :						// 모든 노드를 키 값의 오름차순으로 출력
					tree.print();
				break;
			
			case TERMINATE :
				System.out.println("종료합니다.");
				break;
			}
		} while (menu != Menu.TERMINATE);
		
//		int a;
//		System.out.print("\n메뉴 선택 : ");
//		a = stdIn.nextInt();
	}
}
